package com.biblio.mapper;

import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.Order;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderManagementResponse mapToOrderManagementResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return OrderManagementResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomer().getFullName())
                .orderDate(order.getOrderDate().format(formatter))
                .totalPrice(order.calTotalPrice())
                .paymentMethod(order.getPaymentType().getValue())
                .status(order.getStatus())
                .statusDisplay(order.getStatus().getDescription())
                .statusStyle(order.getStatus().getStatusStyle())
                .build();
    }

    public static OrderDetailsManagementResponse mapToOrderDetailsManagementResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        List<OrderProductResponse> products = order.getLineItems().stream()
                .map(OrderItemMapper::mapToOrderProductResponse)
                .collect(Collectors.toList());

        return OrderDetailsManagementResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomer().getFullName())
                .phoneNumber(order.getCustomer().getPhoneNumber())
                .address(order.getShipping().getAddress().getFullAddress())
                .shippingUnit(order.getShipping().getShippingUnit())
                .shippingFee(order.getShipping().getShippingFee())
                .orderDate(order.getOrderDate().format(formatter))
                .note(order.getNote())
                .products(products)
                .status(order.getStatus())
                .statusDisplay(order.getStatus().getDescription())
                .statusStyle(order.getStatus().getStatusStyle())
                .totalPrice(order.calTotalPrice())
                .paymentMethod(order.getPaymentType().getValue())
                .build();
    }
}
