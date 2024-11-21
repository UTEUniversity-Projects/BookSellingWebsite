package com.biblio.dao;

import com.biblio.entity.CartItem;

public interface ICartItemDAO {
    CartItem addCartItem(CartItem cartItem);
    CartItem updateCartItem(CartItem cartItem);
}
