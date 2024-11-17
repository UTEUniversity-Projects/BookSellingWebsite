package com.biblio.mapper;

import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.Book;
import com.biblio.entity.OrderItem;


public class OrderItemMapper {
    public static OrderProductResponse mapToOrderProductResponse(OrderItem orderItem) {
        Book book = orderItem.getBooks().iterator().next();
        return OrderProductResponse.builder()
                .title(book.getTitle())
                .imagePath(book
                        .getBookTemplate()
                        .getMediaFiles()
                        .iterator().next()
                        .getStoredCode()
                        .replaceAll("image\\d+\\.jpg", "image1.jpg"))
                .quantity(orderItem.getBooks().size())
                .sellingPrice(book.getSellingPrice())
                .totalPrice(orderItem.calPriceItem())
                .build();
    }
}
