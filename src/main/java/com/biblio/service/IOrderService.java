package com.biblio.service;

import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.enumeration.EOrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
    OrderDetailsManagementResponse getOrderDetailsManagementResponse(Long id);

    List<OrderManagementResponse> getAllOrderManagementResponse();

    boolean updateStatus(Long id, EOrderStatus status);

    Long countOrderAtTime(LocalDateTime start, LocalDateTime end);

    Double venueOrderAtTime(LocalDateTime start, LocalDateTime end);
}
