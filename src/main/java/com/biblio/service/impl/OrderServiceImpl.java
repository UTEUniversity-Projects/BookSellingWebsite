package com.biblio.service.impl;

import com.biblio.dao.IOrderDAO;
import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.dto.response.RevenueResponse;
import com.biblio.entity.Order;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.mapper.OrderMapper;
import com.biblio.service.IOrderService;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class OrderServiceImpl implements IOrderService {
    @Inject
    IOrderDAO orderDAO;

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


}
