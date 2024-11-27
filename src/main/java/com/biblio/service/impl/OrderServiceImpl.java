package com.biblio.service.impl;

import com.biblio.dao.IOrderDAO;
import com.biblio.dto.response.*;
import com.biblio.entity.Book;
import com.biblio.entity.Order;
import com.biblio.entity.OrderItem;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.mapper.BookMapper;
import com.biblio.mapper.OrderMapper;
import com.biblio.service.IOrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

        // Tạo danh sách ngày từ start đến end với revenue mặc định là 0.0
        List<RevenueResponse> consolidatedRevenue = new ArrayList<>();
        LocalDate currentDate = start.toLocalDate();
        LocalDate endDate = end.toLocalDate();

        while (!currentDate.isAfter(endDate)) {
            RevenueResponse consolidated = new RevenueResponse();
            consolidated.setDate(currentDate.atStartOfDay());
            consolidated.setRevenue(0.0);
            consolidatedRevenue.add(consolidated);
            currentDate = currentDate.plusDays(1);
        }
        // Duyệt qua revenueResponse và cộng revenue nếu ngày trùng
        for (RevenueResponse response : revenueResponse) {// Tổng revenue từ revenueResponse
            for (RevenueResponse consolidated : consolidatedRevenue) {
                if (response.getDate().toLocalDate().isEqual(consolidated.getDate().toLocalDate())) {
                    consolidated.setRevenue(consolidated.getRevenue() + response.getRevenue());
                    break;
                }
            }
        }


        // Sắp xếp danh sách theo ngày (nếu cần, nhưng thực tế danh sách đã theo thứ tự ngày ban đầu)
        consolidatedRevenue.sort(Comparator.comparing(RevenueResponse::getDate));

        return consolidatedRevenue;
    }

    @Override
    public OrderCustomerResponse findOrderById(Long orderId) {
        return orderDAO.findById(orderId);
    }

    @Override
    public OrderCustomerResponse findOrderByIdCustomer(Long orderId) {
        Order order =  orderDAO.findByIdCustomer(orderId);
        return OrderMapper.toOrderCustomerResponse(order);
    }

    @Override
    public List<OrderCustomerResponse> getAllOrderCustomerResponse(Long customerId) {
        List<Order> orders = orderDAO.findAllOrderForCustomer(customerId);
        List<OrderCustomerResponse> orderCustomerResponse = new ArrayList<>();
//        for (Order order : orders) {
//            orderCustomerResponse.add(OrderMapper.toOrderCustomerResponse(order));
//        }
        for (Order order : orders) {
            if (order == null) {
                System.out.println("Null order found in orders list");
                continue;
            }
            System.out.println("Mapping order with ID: " + order.getId());

            OrderCustomerResponse response = OrderMapper.toOrderCustomerResponse(order);

            if (response == null) {
                System.out.println("Mapper returned null for order ID: " + order.getId());
            } else {
                System.out.println("Mapped response: " + response);
                orderCustomerResponse.add(response);
            }
        }

        return orderCustomerResponse;
    }

    @Override
    public List<OrderCustomerResponse> getOrderCustomerByStatus(Long customerId, String status) {
        // Lấy tất cả các đơn hàng cho khách hàng
        List<Order> orders = orderDAO.findAllOrderForCustomer(customerId);
        List<OrderCustomerResponse> filteredOrderResponses = new ArrayList<>();

        // Kiểm tra nếu status là "all", lấy tất cả đơn hàng
        if ("all".equalsIgnoreCase(status)) {
            // Nếu trạng thái là "all", không lọc theo trạng thái, lấy tất cả
            for (Order order : orders) {
                if (order == null) {
                    System.out.println("Null order found in orders list");
                    continue;
                }

                OrderCustomerResponse response = OrderMapper.toOrderCustomerResponse(order);
                if (response == null) {
                    System.out.println("Mapper returned null for order ID: " + order.getId());
                } else {
                    filteredOrderResponses.add(response);
                }
            }
        } else {
            // Nếu trạng thái không phải "all", chuyển từ String sang EOrderStatus và lọc
            try {
                EOrderStatus orderStatus = EOrderStatus.valueOf(status); // Chuyển đổi String thành EOrderStatus
                for (Order order : orders) {
                    if (order == null) {
                        System.out.println("Null order found in orders list");
                        continue;
                    }

                    // Lọc đơn hàng theo trạng thái
                    if (order.getStatus() != null && order.getStatus().equals(orderStatus)) {
                        OrderCustomerResponse response = OrderMapper.toOrderCustomerResponse(order);
                        if (response == null) {
                            System.out.println("Mapper returned null for order ID: " + order.getId());
                        } else {
                            filteredOrderResponses.add(response);
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                // Trường hợp status không hợp lệ
                System.out.println("Invalid status: " + status);
            }
        }

        return filteredOrderResponses;
    }


    public List<CountBookSoldResponse> getListCountBookSoldAtTime(LocalDateTime start, LocalDateTime end) {
        List<BookSoldResponse> ListBookSold = new ArrayList<>();
        List<Order> list = orderDAO.findAllForManagement();
        for (Order order : list) {
            Order orderTmp = orderDAO.findOneForDetailsManagement(order.getId());
            LocalDateTime orderDate = orderTmp.getOrderDate();
            if ((orderDate.isEqual(start) || orderDate.isAfter(start)) &&
                    (orderDate.isEqual(end) || orderDate.isBefore(end)) &&
                    EOrderStatus.COMPLETE_DELIVERY.equals(orderTmp.getStatus())) {
                for (OrderItem orderItem : orderTmp.getOrderItems()) {
                    for (Book book : orderItem.getBooks()) {
                        ListBookSold.add(BookMapper.toBookSoldResponse(book));
                    }
                }
            }
        }
        List<CountBookSoldResponse> countBookSoldResponse = BookMapper.toCountBookSoldResponse(ListBookSold);
        countBookSoldResponse.sort(Comparator.comparingLong(CountBookSoldResponse::getCountSold).reversed());
        return countBookSoldResponse;

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
