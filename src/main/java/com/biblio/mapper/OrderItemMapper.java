package com.biblio.mapper;

import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OrderItemMapper {
    public static OrderProductResponse mapToOrderProductResponse(OrderItem orderItem) {
        OrderProductResponse orderProductResponse = new OrderProductResponse();
        orderProductResponse.setTitle(orderItem.getBook().getTitle());
        orderProductResponse.setQuantity(orderItem.getQuantity());
        orderProductResponse.setSellingPrice(orderItem.getBook().getSellingPrice());
        orderProductResponse.setTotalPrice(orderItem.calPriceItem());
        return orderProductResponse;
    }
}
