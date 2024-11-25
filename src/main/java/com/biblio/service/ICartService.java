package com.biblio.service;

import com.biblio.dto.request.AddToCartRequest;
import com.biblio.dto.request.UpdateCartItemRequest;
import com.biblio.dto.response.CartResponse;

public interface ICartService {
    CartResponse getCartResponseByAccountId(Long accountId);
    void addToCart(AddToCartRequest addToCartRequest);
    void updateCart(UpdateCartItemRequest updateCartItemRequest);
}
