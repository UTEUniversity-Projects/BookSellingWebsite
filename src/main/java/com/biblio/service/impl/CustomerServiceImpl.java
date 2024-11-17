package com.biblio.service.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.dao.IOrderDAO;
import com.biblio.dao.impl.CustomerDAOImpl;
import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.dto.response.CustomerRegisterResponse;
import com.biblio.dto.response.CustomerReportResponse;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.mapper.CustomerMapper;
import com.biblio.service.ICustomerService;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    @Inject
    private ICustomerDAO customerDAO;

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

    @Override
    public CustomerDetailResponse getCustomerDetailByUsername(String username) {
        Customer customer = customerDAO.findByUsername(username);
        return CustomerMapper.toCustomerDetailResponse(customer);
    }

    @Override
    public Long countCustomersJointAtTime(LocalDateTime start, LocalDateTime end) {
        return customerDAO.findAll().stream()
                .filter(customer -> {
                    LocalDateTime joinAt = customer.getJoinAt();
                    return (joinAt.isEqual(start) || joinAt.isAfter(start)) &&
                            (joinAt.isEqual(end) || joinAt.isBefore(end));
                })
                .count();
    }


}
