package com.biblio.mapper;

import com.biblio.dto.response.CartItemResponse;
import com.biblio.entity.Book;
import com.biblio.entity.CartItem;

public class CartItemMapper {

    public static CartItemResponse toCartItemResponse(CartItem cartItem) {
        Book book = cartItem.getBookTemplate().getBooks().iterator().next();
        return CartItemResponse.builder()
                .id(cartItem.getId())
                .bookId(cartItem.getBookTemplate().getId())
                .title(book.getTitle())
                .imageUrl(cartItem.getBookTemplate().getMediaFiles().iterator().next().getStoredCode().replaceAll("image\\d+\\.jpg", "image1.jpg"))
                .sellingPrice(book.getSellingPrice())
                .quantity(cartItem.getQuantity())
                .build();
    }
}
