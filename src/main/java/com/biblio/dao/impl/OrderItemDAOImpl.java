package com.biblio.dao.impl;

import com.biblio.dao.IOrderItemDAO;
import com.biblio.entity.LineItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class OrderItemDAOImpl extends GenericDAOImpl<LineItem> implements IOrderItemDAO {

    public OrderItemDAOImpl(Class<LineItem> entityClass) {
        super(entityClass);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<LineItem> findByOrderId(Long orderId) {
        String jpql = "SELECT li FROM LineItem li WHERE li.order.id = :orderId";
        return entityManager.createQuery(jpql, LineItem.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }
}