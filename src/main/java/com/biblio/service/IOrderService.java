package com.biblio.service;

import com.biblio.dto.response.OrderDetailsResponse;
import com.biblio.dto.response.OrderGetListResponse;
import com.biblio.entity.Order;

import java.util.List;

public interface IOrderService {
    OrderDetailsResponse getOrderDetails(Long id);
    List<OrderGetListResponse> getOrders();
}
