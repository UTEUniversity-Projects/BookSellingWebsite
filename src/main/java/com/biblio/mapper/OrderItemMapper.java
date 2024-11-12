package com.biblio.mapper;

import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.MediaFile;
import com.biblio.entity.OrderItem;


public class OrderItemMapper {
    public static OrderProductResponse mapToOrderProductResponse(OrderItem orderItem) {
        return OrderProductResponse.builder()
                .title(orderItem.getBook().getTitle())
                .imagePath(orderItem.getBook()
                        .getMetadata()
                        .getMediaFiles()
                        .iterator().next()
                        .getStoredCode()
                        .replaceAll("image\\d+\\.jpg", "image1.jpg"))
                .quantity(orderItem.getQuantity())
                .sellingPrice(orderItem.getBook().getSellingPrice())
                .totalPrice(orderItem.calPriceItem())
                .build();
    }
}
