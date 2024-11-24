package com.biblio.dao;

import com.biblio.entity.LineItem;

import java.util.List;

public interface IOrderItemDAO {
    List<LineItem> findByOrderId(Long orderId);
}
