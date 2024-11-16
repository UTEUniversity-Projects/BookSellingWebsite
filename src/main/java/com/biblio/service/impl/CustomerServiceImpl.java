package com.biblio.service.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.dto.response.CustomerRegisterResponse;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.mapper.CustomerMapper;
import com.biblio.service.ICustomerService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    @Inject
    private ICustomerDAO customerDAO;

    @Override
    public List<CustomerDetailResponse> findAll() {
        List<CustomerDetailResponse> list = new ArrayList<>();
        for (Customer customer : customerDAO.findAll()) {
            list.add(CustomerMapper.toCustomerDetailResponse(customer));
        }
        return list;
    }

    @Override
    public void deactivateCustomer(Long id) {
        Customer customer = customerDAO.findById(id);
        customer.getAccount().setStatus(EAccountStatus.INACTIVE);
        customerDAO.deactivateCustomer(customer);
    }

    @Override
    public void activateCustomer(Long id) {
        Customer customer = customerDAO.findById(id);
        customer.getAccount().setStatus(EAccountStatus.ACTIVE);
        customerDAO.activateCustomer(customer);
    }

    @Override
    public CustomerDetailResponse findById(Long id) {
        return CustomerMapper.toCustomerDetailResponse(customerDAO.findById(id));
    }

    @Override
    public CustomerRegisterResponse addCustomer(CustomerRegisterRequest request) {
        Customer customer = CustomerMapper.toCustomer(request);
        return CustomerMapper.toCustomerRegisterResponse(customerDAO.addCustomer(customer));
    }

    @Override
    public boolean isEmailExisted(String email) {
        return customerDAO.existsByEmail(email);
    }

    @Override
    public boolean isPhoneNumberExisted(String phoneNumber) {
        return customerDAO.existsByPhoneNumber(phoneNumber);
    }
}
