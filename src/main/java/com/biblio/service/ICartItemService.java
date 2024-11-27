package com.biblio.service;

import com.biblio.dto.request.DeleteCartItemRequest;
import com.biblio.dto.request.UpdateCartItemRequest;

public interface ICartItemService {
    void updateCartItem (UpdateCartItemRequest updateCartItemRequest);
    void deleteCartItem (DeleteCartItemRequest deleteCartItemRequest);
}
