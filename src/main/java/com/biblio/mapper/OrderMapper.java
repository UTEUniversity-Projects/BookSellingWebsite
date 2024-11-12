package com.biblio.mapper;

import com.biblio.dto.response.OrderDetailsResponse;
import com.biblio.dto.response.OrderGetListResponse;
import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.Order;
import com.biblio.entity.OrderItem;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderGetListResponse mapToOrderGetListResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        return OrderGetListResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomer().getFullName())
                .orderDate(order.getOrderDate().format(formatter))
                .status(order.getStatus())
                .statusDisplay(order.getStatus().getDescription())
                .statusStyle(order.getStatus().getStatusStyle())
                .totalPrice(order.calTotalPrice())
                .build();
    }

    public static OrderDetailsResponse mapToOrderDetailsResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        List<OrderProductResponse> products = order.getOrderItems().stream()
                .map(OrderItemMapper::mapToOrderProductResponse)
                .collect(Collectors.toList());

        return OrderDetailsResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomer().getFullName())
                .phoneNumber(order.getCustomer().getPhoneNumber())
                .address(order.getAddress().getFullAddress())
                .orderDate(order.getOrderDate().format(formatter))
                .note(order.getNote())
                .products(products)
                .status(order.getStatus())
                .statusDisplay(order.getStatus().getDescription())
                .statusStyle(order.getStatus().getStatusStyle())
                .totalPrice(order.calTotalPrice())
                .build();
    }
}
