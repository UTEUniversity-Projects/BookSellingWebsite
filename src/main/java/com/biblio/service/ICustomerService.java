package com.biblio.service;

import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerGetListResponse> findAll();
}
