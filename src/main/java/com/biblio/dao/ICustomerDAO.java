package com.biblio.dao;

import com.biblio.entity.Customer;

import java.util.List;

public interface ICustomerDAO extends IGenericDAO<Customer, Long> {
    List<Customer> findAll();
}
