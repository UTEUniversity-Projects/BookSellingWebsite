package com.biblio.dao.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.entity.Customer;

import java.util.List;

public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements ICustomerDAO {
    public CustomerDAOImpl() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findAll() {
//        String jpql = "SELECT c FROM Customer c";
//        return super.findAll(jpql);
        return  super.findAll();
    }


    @Override
    public void deactivateCustomer(Customer customer) {
        System.out.println(customer.toString());
        //super.update(customer);
    }

    @Override
    public void activateCustomer(Customer customer) {
        super.update(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        super.save(customer);
    }

}
