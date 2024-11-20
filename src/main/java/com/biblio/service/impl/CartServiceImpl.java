package com.biblio.service.impl;

import com.biblio.dao.ICartDAO;
import com.biblio.dao.ICustomerDAO;
import com.biblio.dto.response.CartResponse;
import com.biblio.entity.Cart;
import com.biblio.entity.Customer;
import com.biblio.mapper.CartMapper;
import com.biblio.service.ICartService;

import javax.inject.Inject;

public class CartServiceImpl implements ICartService {

    @Inject
    private ICartDAO cartDAO;

    @Inject
    private ICustomerDAO customerDAO;

    @Override
    public CartResponse getCartResponseByUsername(String username) {

        Cart cart = cartDAO.findByUsername(username);
        return CartMapper.toCartResponse(cart);
    }
}
