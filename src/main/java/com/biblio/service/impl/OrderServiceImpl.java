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
import java.util.stream.Collectors;

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
    public List<OrderCustomerResponse> findOrdersByCustomerId(Long customerId) {
        // Fetch data from DAO
        List<Order> orders = orderDAO.findByJPQL(customerId);

        // Convert Order entities to OrderCustomerResponse DTOs
        return orders.stream()
                .map(order -> {
                    // Initialize a set for books in the response
                    Set<BookResponse> bookResponses = new HashSet<>();

                    // Loop through each LineItem and its associated books
                    for (OrderItem lineItem : order.getOrderItems()) {
                        for (Book book : lineItem.getBooks()) {
                            // Add the book to the set of bookResponses
                            BookResponse bookResponse = BookResponse.builder()
                                    .id(String.valueOf(book.getId()))
                                    .title(book.getTitle())
                                    .description(book.getDescription())
                                    .sellingPrice(String.valueOf(book.getSellingPrice()))
                                    .build();
                            bookResponses.add(bookResponse);
                        }
                    }

                    // Calculate the total price if necessary (sum of line items or other logic)
                    Double totalPrice = order.getOrderItems().stream()
                            .mapToDouble(OrderItem::calPriceItem)
                            .sum();

                    // Return the mapped OrderCustomerResponse with the list of books
                    return new OrderCustomerResponse(
                            order.getId() ,
                            order.getNote(),
                            order.getOrderDate() != null ? order.getOrderDate().toString() : null,  // Convert LocalDateTime to String
                            order.getPaymentType() != null ? order.getPaymentType().name() : null,
                            order.getStatus() != null ? order.getStatus().name() : null,
                            order.getVat(),
                            order.getCustomer() != null ? order.getCustomer().getId() : null,
                            order.getShipping() != null ? order.getShipping().getId() : null,
                            totalPrice,
                            bookResponses  // Add the set of BookResponse objects
                    );
                })
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
    public List<CountOrderOfCustomerResponse> getCountOrderOfCustomerAtTime(LocalDateTime start, LocalDateTime end) {
        List<OrderOfCustomerResponse> orderOfCustomerResponse = new ArrayList<>();
        List<CountOrderOfCustomerResponse> countOrderOfCustomerResponses = new ArrayList<>();
        List<Order> list = orderDAO.findAllForManagement();

        for (Order order : list) {
            Order orderTmp = orderDAO.findOneForDetailsManagement(order.getId());
            LocalDateTime orderDate = orderTmp.getOrderDate();
            if ((orderDate.isEqual(start) || orderDate.isAfter(start)) &&
                    (orderDate.isEqual(end) || orderDate.isBefore(end)) &&
                    EOrderStatus.COMPLETE_DELIVERY.equals(orderTmp.getStatus())) {
                orderOfCustomerResponse.add(OrderMapper.toOrderOfCustomerResponse(orderTmp));
            }
        }

        Map<Long, CountOrderOfCustomerResponse> customerOrderCountMap = new HashMap<>();
        for (OrderOfCustomerResponse order : orderOfCustomerResponse) {
            Long customerId = order.getCustomerId();
            String customerName = order.getCustomerName();

            if (customerOrderCountMap.containsKey(customerId)) {
                CountOrderOfCustomerResponse response = customerOrderCountMap.get(customerId);
                response.setCountOrders(response.getCountOrders() + 1);
            } else {
                customerOrderCountMap.put(customerId, CountOrderOfCustomerResponse.builder()
                        .customerId(customerId)
                        .customerName(customerName)
                        .countOrders(1L)
                        .build());
            }
        }

        countOrderOfCustomerResponses.addAll(customerOrderCountMap.values());
        return countOrderOfCustomerResponses;
    }



    @Transactional
    @Override
    public void confirmOrder(Long orderId) {
        Order order = orderDAO.findOne(orderId);
        order.setStatus(EOrderStatus.PACKING);
        orderDAO.updateOrder(order);
    }

    @Transactional
    @Override
    public void rejectOrder(Long orderId, String reason) {
        Order order = orderDAO.findOne(orderId);
        order.setStatus(EOrderStatus.CANCELED);
        orderDAO.updateOrder(order);
    }


}
