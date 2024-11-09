package com.biblio.mapper;

import com.biblio.dto.response.OrderDetailsResponse;
import com.biblio.dto.response.OrderGetListResponse;
import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.Order;
import com.biblio.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static OrderGetListResponse mapToOrderGetListResponse(Order order) {
        OrderGetListResponse orderGetListResponse = new OrderGetListResponse();
        orderGetListResponse.setId(order.getId());
        orderGetListResponse.setCustomerName(order.getCustomer().getFullName());
        orderGetListResponse.setStatus(order.getStatus());
        orderGetListResponse.setStatusDisplay(order.getStatus().getDescription());
        orderGetListResponse.setStatusStyle(order.getStatus().getStatusStyle());
        orderGetListResponse.setTotalPrice(order.calTotalPrice());
        return orderGetListResponse;
    }

    public static OrderDetailsResponse mapToOrderDetailsResponse(Order order) {
        OrderDetailsResponse orderDetailsResponse = new OrderDetailsResponse();
        orderDetailsResponse.setId(order.getId());
        orderDetailsResponse.setCustomerName(order.getCustomer().getFullName());
        orderDetailsResponse.setPhoneNumber(order.getCustomer().getPhoneNumber());
        orderDetailsResponse.setAddress(order.getAddress().getFullAddress());
        List<OrderProductResponse> products = new ArrayList<>();
        for(OrderItem item : order.getOrderItems()) {
            products.add(OrderItemMapper.mapToOrderProductResponse(item));
        }
        orderDetailsResponse.setProducts(products);
        orderDetailsResponse.setStatus(order.getStatus());
        orderDetailsResponse.setStatusDisplay(order.getStatus().getDescription());
        orderDetailsResponse.setStatusStyle(order.getStatus().getStatusStyle());
        orderDetailsResponse.setTotalPrice(order.calTotalPrice());
        return orderDetailsResponse;
    }
}
