package com.biblio.service;

import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;

import java.util.List;

public interface IOrderService {
    OrderDetailsManagementResponse getOrderDetailsManagementResponse(Long id);
    List<OrderManagementResponse> getAllOrderManagementResponse();
}
