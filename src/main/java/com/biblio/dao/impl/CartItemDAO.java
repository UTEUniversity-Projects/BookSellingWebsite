package com.biblio.dao.impl;

import com.biblio.dao.ICartItemDAO;
import com.biblio.entity.CartItem;

public class CartItemDAO extends GenericDAOImpl<CartItem> implements ICartItemDAO {
    public CartItemDAO() {
        super(CartItem.class);
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return super.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return super.update(cartItem);
    }
}
