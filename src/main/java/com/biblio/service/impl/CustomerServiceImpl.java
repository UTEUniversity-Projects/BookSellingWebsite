package com.biblio.service.impl;

import com.biblio.dao.ICartDAO;
import com.biblio.dao.ICustomerDAO;
import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.*;
import com.biblio.entity.Cart;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.mapper.CustomerMapper;
import com.biblio.service.ICustomerService;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    @Inject
    private ICustomerDAO customerDAO;

    @Inject
    private ICartDAO cartDAO;

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
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cartDAO.addCart(cart);
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

    @Override
    public List<Customer> findAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public List<CountCustomerJoinResponse> countNewCustomersAtTime(LocalDateTime start, LocalDateTime end) {
        List<NewCustomerResponse> list = new ArrayList<>();
        for (Customer customer : customerDAO.findAll()) {
            list.add(CustomerMapper.toNewCustomerResponse(customer));
        }
        List<CountCustomerJoinResponse> countCustomerJoins = new ArrayList<>();
        LocalDate currentDate = start.toLocalDate();
        LocalDate endDate = end.toLocalDate();

        while (!currentDate.isAfter(endDate)) {
            CountCustomerJoinResponse countCustomerJoin = new CountCustomerJoinResponse();
            countCustomerJoin.setJointAt(currentDate.atStartOfDay());
            countCustomerJoin.setCount(0L);
            countCustomerJoins.add(countCustomerJoin);
            currentDate = currentDate.plusDays(1);
        }

        for (NewCustomerResponse newCustomer : list) {
            for (CountCustomerJoinResponse countCustomerJoin : countCustomerJoins) {
                if(newCustomer.getJointAt().isEqual(countCustomerJoin.getJointAt())) {
                    countCustomerJoin.setCount(countCustomerJoin.getCount() + 1L);
                    break;
                }
            }
        }
        return countCustomerJoins;
    }

}
