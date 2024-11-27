package com.biblio.service.impl;

import com.biblio.dao.ICartItemDAO;
import com.biblio.dto.request.DeleteCartItemRequest;
import com.biblio.dto.request.UpdateCartItemRequest;
import com.biblio.entity.CartItem;
import com.biblio.service.ICartItemService;

import javax.inject.Inject;

public class CartItemServiceImpl implements ICartItemService {
    @Inject
    private ICartItemDAO cartItemDAO;

    @Override
    public void updateCartItem(UpdateCartItemRequest updateCartItemRequest) {
        CartItem cartItem = cartItemDAO.getCartItemById(updateCartItemRequest.getCartItemId());
        cartItem.setQuantity(updateCartItemRequest.getQuantity());
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void deleteCartItem(DeleteCartItemRequest deleteCartItemRequest) {
        cartItemDAO.deleteCartItem(deleteCartItemRequest.getCartItemId());
    }
}
