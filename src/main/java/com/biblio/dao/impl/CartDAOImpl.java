package com.biblio.dao.impl;

import com.biblio.dao.ICartDAO;
import com.biblio.entity.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartDAOImpl extends GenericDAOImpl<Cart> implements ICartDAO {
    public CartDAOImpl() {
        super(Cart.class);
    }

    @Override
    public Cart findByUsername(String username) {
        String jpql = "SELECT DISTINCT cart FROM Cart cart "
                + "JOIN FETCH cart.customer customer "
                + "JOIN FETCH cart.cartItems items "
                + "LEFT JOIN FETCH items.bookTemplate bookTemplate "
                + "WHERE customer.account.username = :username";

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        return super.findSingleByJPQL(jpql, params);
    }

    public static void main(String[] args) {
        CartDAOImpl cartDAO = new CartDAOImpl();
        Cart cart = cartDAO.findByUsername("customer_1");
        System.out.println(cart.getCartItems().size());


    }
}
