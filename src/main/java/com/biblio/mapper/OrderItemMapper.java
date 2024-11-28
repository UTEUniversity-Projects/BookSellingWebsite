package com.biblio.mapper;

import com.biblio.dto.response.OrderProductResponse;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.OrderItem;
import com.biblio.entity.Publisher;

import java.util.HashSet;
import java.util.Set;


public class OrderItemMapper {
    public static OrderProductResponse mapToOrderProductResponse(OrderItem orderItem) {
        Book book = orderItem.getBooks().iterator().next();
        return OrderProductResponse.builder()
                .title(book.getTitle())
                .imagePath(book.getBookTemplate()
                        .getMediaFiles().get(0)
                        .getStoredCode())
                .quantity(orderItem.getBooks().size())
                .sellingPrice(book.getSellingPrice())
                .totalPrice(orderItem.calPriceItem())
                .build();
    }

    public static OrderProductResponse toOrderProductCustomerResponse(OrderItem orderItem) {
        Book book = orderItem.getBooks().iterator().next();

        String publisherName = null;
        if (orderItem != null) {
            // Duyệt qua các OrderItem để lấy thông tin sách
            Set<Book> books = orderItem.getBooks();
            if (books != null && !books.isEmpty()) {
                // Duyệt qua danh sách sách để lấy thông tin Publisher
                BookTemplate bookTemplate = book.getBookTemplate();
                if (bookTemplate != null) {
                    // Lấy Publisher từ BookTemplate
                    Publisher publisher = bookTemplate.getPublisher();
                    if (publisher != null) {
                        // Lấy tên nhà xuất bản
                        publisherName = publisher.getName();
                        // Bạn có thể sử dụng publisherName tại đây
                    }
                }

            }


        }
        return OrderProductResponse.builder()
                .bookTemplateId(book.getBookTemplate().getId())
                .title(book.getTitle())
                .imagePath(book.getBookTemplate()
                        .getMediaFiles().get(0)
                        .getStoredCode())
                .quantity(orderItem.getBooks().size())
                .sellingPrice(book.getSellingPrice())
                .totalPrice(orderItem.calPriceItem())
                .publisherName(publisherName)
                .build();
    }
}
