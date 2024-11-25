package com.biblio.dao;

import com.biblio.entity.Cart;

public interface ICartDAO {
    Cart findByAccountId(Long accountId);
    Cart findById(Long cartId);
}
