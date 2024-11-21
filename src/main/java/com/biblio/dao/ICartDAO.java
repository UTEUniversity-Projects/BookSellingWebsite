package com.biblio.dao;

import com.biblio.entity.Cart;

public interface ICartDAO {
    Cart findByUsername(String username);
    Cart findById(Long cartId);
}
