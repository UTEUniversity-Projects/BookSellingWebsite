package com.biblio.mapper;

import com.biblio.dto.response.CartItemResponse;
import com.biblio.dto.response.CartResponse;
import com.biblio.entity.Cart;
import com.biblio.entity.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {

    public static CartResponse toCartResponse(Cart cart) {
        List<CartItemResponse> cartItemResponse = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            cartItemResponse.add(CartItemMapper.toCartItemResponse(cartItem));
        }
        return CartResponse.builder()
                .cartItems(cartItemResponse)
                .build();
    }
}
