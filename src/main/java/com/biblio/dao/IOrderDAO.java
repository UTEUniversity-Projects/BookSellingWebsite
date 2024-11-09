package com.biblio.dao;

import com.biblio.entity.Order;

import java.util.List;

public interface IOrderDAO {
    Order findOne(Long id);
    List<Order> findAll();
}
