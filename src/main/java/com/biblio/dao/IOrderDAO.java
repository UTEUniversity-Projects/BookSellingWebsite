package com.biblio.dao;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.entity.Order;
import com.biblio.enumeration.EOrderStatus;

import java.util.List;

public interface IOrderDAO {

    Order findOne(Long id);

    List<Order> findAll();

    List<Order> findAllForManagement();

    Order findOneForDetailsManagement(Long id);

    List<Order> findByJPQL(Long customerId);

    List<Order> findAllOrderForCustomer(Long customerId);

    boolean updateStatus(Long id, EOrderStatus status);

    OrderCustomerResponse findById(Long id);
    Order findByIdCustomer(Long id);
    void updateOrder(Order order);

}
