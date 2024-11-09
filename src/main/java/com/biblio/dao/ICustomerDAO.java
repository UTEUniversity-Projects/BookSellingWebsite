package com.biblio.dao;

import com.biblio.entity.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();
    void deactivateCustomer(Customer customer);
    void activateCustomer(Customer customer);
    void addCustomer(Customer customer);
}
