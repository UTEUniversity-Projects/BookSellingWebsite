package com.biblio.service;

import com.biblio.dto.response.*;
import com.biblio.enumeration.EOrderStatus;

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

    List<CountBookSoldResponse> getListCountBookSoldAtTime(LocalDateTime start, LocalDateTime end);

    List<CountOrderOfCustomerResponse> getCountOrderOfCustomerAtTime(LocalDateTime start, LocalDateTime end);

    public OrderCustomerResponse findOrderById(Long orderId);
    void confirmOrder(Long orderId);
    void rejectOrder(Long orderId, String reason);


}
