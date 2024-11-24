package com.biblio.dao.impl;

import com.biblio.dao.IOrderItemDAO;
import com.biblio.entity.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class OrderItemDAOImpl extends GenericDAOImpl<OrderItem> implements IOrderItemDAO {

    public OrderItemDAOImpl(Class<OrderItem> entityClass) {
        super(entityClass);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<OrderItem> findByOrderId(Long orderId) {
        String jpql = "SELECT li FROM OrderItem li WHERE li.order.id = :orderId";
        return entityManager.createQuery(jpql, OrderItem.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }
}