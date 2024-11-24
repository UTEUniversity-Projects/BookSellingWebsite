package com.biblio.service;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.entity.Order;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.dto.response.RevenueResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
  
    OrderDetailsManagementResponse getOrderDetailsManagementResponse(Long id);

    List<OrderManagementResponse> getAllOrderManagementResponse();

    boolean updateStatus(Long id, EOrderStatus status);

    Long countOrderAtTime(LocalDateTime start, LocalDateTime end);
  
    List<OrderCustomerResponse> findOrdersByCustomerId(Long customerId);

    Double revenueOrderAtTime(LocalDateTime start, LocalDateTime end);
  
    List<RevenueResponse> getListRevenueAtTime(LocalDateTime start, LocalDateTime end);

    public OrderCustomerResponse findOrderById(Long orderId);
    void confirmOrder(Long orderId);
    void rejectOrder(Long orderId, String reason);


}
