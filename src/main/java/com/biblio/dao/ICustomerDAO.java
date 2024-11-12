package com.biblio.dao;

import com.biblio.entity.Customer;

import java.util.List;

public interface ICustomerDAO extends IGenericDAO<Customer> {
    List<Customer> findAll();

    Customer findById(Long id);

    void deactivateCustomer(Customer customer);

    void activateCustomer(Customer customer);

    Customer addCustomer(Customer customer);

    boolean isEmailExisted(String email);

    boolean isPhoneNumberExisted(String phoneNumber);

    public void updateSupport_Notification(Customer customer);
}
