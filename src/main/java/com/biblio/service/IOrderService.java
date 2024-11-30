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

    Double revenueOrderAtTime(LocalDateTime start, LocalDateTime end);
  
    List<RevenueResponse> getListRevenueAtTime(LocalDateTime start, LocalDateTime end);

    List<OrderCustomerResponse> getOrderCustomerByStatus(Long customerId, String status);

    List<CountBookSoldResponse> getListCountBookSoldAtTime(LocalDateTime start, LocalDateTime end);
  
    List<OrderCustomerResponse> getAllOrderCustomerResponse(Long customerId);

    OrderCustomerResponse findOrderById(Long orderId);
  
    OrderCustomerResponse findOrderByIdCustomer(Long orderId);

    List<CountOrderOfCustomerResponse> getCountOrderOfCustomerAtTime(LocalDateTime start, LocalDateTime end);

    List<OrderReturnAtTimeResponse> getListOrderReturnAtTime(LocalDateTime start, LocalDateTime end);
}
