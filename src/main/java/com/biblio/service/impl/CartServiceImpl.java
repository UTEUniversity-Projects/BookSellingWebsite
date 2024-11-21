package com.biblio.service.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dao.ICartDAO;
import com.biblio.dao.ICartItemDAO;
import com.biblio.dao.ICustomerDAO;
import com.biblio.dto.request.AddToCartRequest;
import com.biblio.dto.response.CartResponse;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.Cart;
import com.biblio.entity.CartItem;
import com.biblio.entity.Customer;
import com.biblio.mapper.CartMapper;
import com.biblio.service.ICartService;

import javax.inject.Inject;

public class CartServiceImpl implements ICartService {

    @Inject
    private ICartDAO cartDAO;

    @Inject
    private IBookTemplateDAO bookTemplateDAO;

    @Inject
    private ICartItemDAO cartItemDAO;

    @Override
    public CartResponse getCartResponseByUsername(String username) {

        Cart cart = cartDAO.findByUsername(username);
        return CartMapper.toCartResponse(cart);
    }

    @Override
    public CartResponse addToCart(AddToCartRequest request) {
        Cart cart = cartDAO.findById(request.getCartId());

        BookTemplate bookTemplate = bookTemplateDAO.findById(request.getBookTemplateId());

        CartItem existingItem = cart.getCartItems().stream()
                .filter(item -> item.getBookTemplate().getId().equals(request.getBookTemplateId()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());
            cartItemDAO.updateCartItem(existingItem);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setBookTemplate(bookTemplate);
            newItem.setQuantity(request.getQuantity());
            cartItemDAO.addCartItem(newItem);
        }
        return CartMapper.toCartResponse(cart);
    }
}
