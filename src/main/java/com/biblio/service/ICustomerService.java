package com.biblio.service;

import com.biblio.dto.response.CustomerGetListResponse;

import java.util.List;

public interface ICustomerService {
    List<CustomerGetListResponse> findAll();
    void deactivateCustomer(Long id);
    void activateCustomer(Long id);
}
