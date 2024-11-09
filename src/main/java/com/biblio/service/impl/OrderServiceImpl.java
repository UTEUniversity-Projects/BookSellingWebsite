package com.biblio.service.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.dao.IOrderDAO;
import com.biblio.dao.impl.OrderDAOImpl;
import com.biblio.dto.response.OrderDetailsResponse;
import com.biblio.dto.response.OrderGetListResponse;
import com.biblio.entity.Order;
import com.biblio.mapper.OrderMapper;
import com.biblio.service.IOrderService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    @Inject
    IOrderDAO orderDAO;

    @Override
    public OrderDetailsResponse getOrderDetails(Long id) {
        Order order = orderDAO.findOne(id);
        return OrderMapper.mapToOrderDetailsResponse(order);
    }

    @Override
    public List<OrderGetListResponse> getOrders() {
        List<Order> orderEntities = orderDAO.findAll();
        List<OrderGetListResponse> orderDTOs = new ArrayList<>();
        for (Order order : orderEntities) {
            orderDTOs.add(OrderMapper.mapToOrderGetListResponse(order));
        }
        return orderDTOs;
    }
}
