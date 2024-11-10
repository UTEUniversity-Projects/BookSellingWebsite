package com.biblio.service.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.mapper.CustomerMapper;
import com.biblio.service.ICustomerService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    @Inject
    ICustomerDAO customerDAO;
    @Override
    public List<CustomerGetListResponse> findAll() {
        List<CustomerGetListResponse> list = new ArrayList<>();
        for (Customer customer : customerDAO.findAll()) {
            list.add(CustomerMapper.toCustomerGetListResponse(customer));
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
    public CustomerGetListResponse findById(Long id) {
        CustomerGetListResponse customerGetListResponse = new CustomerGetListResponse();
        return CustomerMapper.toCustomerGetListResponse(customerDAO.findById(id));
    }

    @Override
    public void addCustomer(CustomerRegisterRequest request) {

        Customer customer = CustomerMapper.toCustomerRegister(request);
        customerDAO.addCustomer(customer);
    }

}
