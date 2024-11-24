package com.biblio.service.impl;

import com.biblio.dao.IOrderDAO;
import com.biblio.dao.impl.OrderDAOImpl;
import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.dto.response.RevenueResponse;
import com.biblio.entity.Order;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.mapper.OrderMapper;
import com.biblio.service.IOrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class OrderServiceImpl implements IOrderService {
    IOrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public OrderDetailsManagementResponse getOrderDetailsManagementResponse(Long id) {
        Order order = orderDAO.findOneForDetailsManagement(id);
        return OrderMapper.mapToOrderDetailsManagementResponse(order);
    }

    @Override
    public List<OrderManagementResponse> getAllOrderManagementResponse() {
        List<Order> orders = orderDAO.findAllForManagement();
        List<OrderManagementResponse> orderManagementResponse = new ArrayList<>();
        for (Order order : orders) {
            orderManagementResponse.add(OrderMapper.mapToOrderManagementResponse(order));
        }
        return orderManagementResponse;
    }

    @Override
    public boolean updateStatus(Long id, EOrderStatus status) {
        return orderDAO.updateStatus(id, status);
    }

    @Override
    public Long countOrderAtTime(LocalDateTime start, LocalDateTime end) {
        List<Order> list = orderDAO.findAll();
        Long count = 0L;

        for (Order order : list) {
            LocalDateTime orderDate = order.getOrderDate();
            if ((orderDate.isEqual(start) || orderDate.isAfter(start)) &&
                    (orderDate.isEqual(end) || orderDate.isBefore(end)) &&
                    EOrderStatus.COMPLETE_DELIVERY.equals(order.getStatus())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Double revenueOrderAtTime(LocalDateTime start, LocalDateTime end) {
        Double venue = 0.0;
        List<Order> list = orderDAO.findAllForManagement();
        for (Order order : list) {
            LocalDateTime orderDate = order.getOrderDate();
            if ((orderDate.isEqual(start) || orderDate.isAfter(start)) &&
                    (orderDate.isEqual(end) || orderDate.isBefore(end)) &&
                    EOrderStatus.COMPLETE_DELIVERY.equals(order.getStatus())) {
//                for (OrderItem orderItem : order.getOrderItems()) {
//                    for (Book book : orderItem.getBooks()) {
//                        venue += book.getSellingPrice();
//                    }
//                }
                venue += order.calTotalPrice();
            }
        }
        return venue;
    }

    @Override
    public List<OrderCustomerResponse> findOrdersByCustomerId(Long customerId) {
        // Fetch data from DAO
        List<Order> orders = orderDAO.findByJPQL(customerId);

        // Convert Order entities to OrderCustomerResponse DTOs
        return orders.stream()
                .map(order -> new OrderCustomerResponse(
                        order.getId(),
                        order.getNote(),
                        order.getOrderDate(),
                        order.getPaymentType() != null ? order.getPaymentType().name() : null, // Convert enum to String
                        order.getStatus() != null ? order.getStatus().name() : null, // Convert enum to String
                        order.getVat(),
                        order.getCustomer() != null ? order.getCustomer().getId() : null,
                        order.getShipping() != null ? order.getShipping().getId() : null
                ))
                .collect(Collectors.toList());
    }

    public List<RevenueResponse> getListRevenueAtTime(LocalDateTime start, LocalDateTime end) {
        List<RevenueResponse> revenueResponse = new ArrayList<>();
        List<Order> orders = orderDAO.findAllForManagement();

        for (Order order : orders) {
            LocalDateTime orderDate = order.getOrderDate();
            if ((orderDate.isEqual(start) || orderDate.isAfter(start)) &&
                    (orderDate.isEqual(end) || orderDate.isBefore(end)) &&
                    EOrderStatus.COMPLETE_DELIVERY.equals(order.getStatus())) {
                revenueResponse.add(OrderMapper.toRevenueResponse(order));
            }
        }

        Map<LocalDate, Double> revenueMap = new HashMap<>();
        for (RevenueResponse response : revenueResponse) {
            LocalDate date = response.getDate().toLocalDate();
            revenueMap.put(date, revenueMap.getOrDefault(date, 0.0) + response.getRevenue());
        }

        List<RevenueResponse> consolidatedRevenue = new ArrayList<>();
        for (Map.Entry<LocalDate, Double> entry : revenueMap.entrySet()) {
            RevenueResponse consolidated = new RevenueResponse();
            consolidated.setDate(entry.getKey().atStartOfDay());
            consolidated.setRevenue(entry.getValue());
            consolidatedRevenue.add(consolidated);
        }

        // Sắp xếp danh sách theo ngày (date)
        consolidatedRevenue.sort(Comparator.comparing(RevenueResponse::getDate));

        return consolidatedRevenue;
    }

    @Override
    public OrderCustomerResponse findOrderById(Long orderId) {
        return orderDAO.findById(orderId);
    }

    @Override
    @Transactional
    public void confirmOrder(Long orderId) {
        Order order = orderDAO.findOne(orderId);
        order.setStatus(EOrderStatus.PACKING);
        orderDAO.updateOrder(order);
    }

    @Override
    @Transactional
    public void rejectOrder(Long orderId, String reason) {
        Order order = orderDAO.findOne(orderId);
        order.setStatus(EOrderStatus.CANCELED);
        orderDAO.updateOrder(order);
    }



}
