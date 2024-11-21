package com.biblio.service;

import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.dto.response.RevenueResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
    OrderDetailsManagementResponse getOrderDetailsManagementResponse(Long id);

    List<OrderManagementResponse> getAllOrderManagementResponse();

    Long countOrderAtTime(LocalDateTime start, LocalDateTime end);

    Double revenueOrderAtTime(LocalDateTime start, LocalDateTime end);
    List<RevenueResponse> getListRevenueAtTime(LocalDateTime start, LocalDateTime end);
}
