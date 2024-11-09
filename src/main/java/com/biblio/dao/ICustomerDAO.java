package com.biblio.dao;

import com.biblio.entity.Customer;

import java.util.List;

public interface ICustomerDAO extends IGenericDAO<Customer> {
    List<Customer> findAll();
    Customer findById(Long id);
    void deactivateCustomer(Customer customer);
    void activateCustomer(Customer customer);
}
