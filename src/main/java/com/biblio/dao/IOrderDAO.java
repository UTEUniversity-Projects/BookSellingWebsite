package com.biblio.dao;

import com.biblio.entity.Order;

import java.util.List;

public interface IOrderDAO {

    Order findOne(Long id);

    List<Order> findAll();

    List<Order> findAllForManagement();

    Order findOneForDetailsManagement(Long id);


    List<Order> findByJPQL(Long customerId);
}
