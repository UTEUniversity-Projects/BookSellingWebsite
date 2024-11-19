package com.biblio.service;

import com.biblio.dto.response.CartResponse;

public interface ICartService {
    CartResponse getCartResponseByUsername(String username);
}
