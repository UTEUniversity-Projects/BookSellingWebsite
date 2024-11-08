package com.biblio.service.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.entity.Customer;
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
}
