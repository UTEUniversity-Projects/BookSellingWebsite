package com.biblio.service;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.dto.response.CustomerRegisterResponse;

import java.util.List;

public interface ICustomerService {

    List<CustomerDetailResponse> findAll();

    void deactivateCustomer(Long id);

    void activateCustomer(Long id);

    CustomerRegisterResponse addCustomer(CustomerRegisterRequest request);

    CustomerDetailResponse findById(Long id);

    boolean isEmailExisted(String email);

    boolean isPhoneNumberExisted(String phoneNumber);

    CustomerDetailResponse getCustomerDetailByUsername(String username);
}
