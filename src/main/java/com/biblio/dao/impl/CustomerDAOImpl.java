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
        return  super.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return super.findById(id);
    }


    @Override
    public void deactivateCustomer(Customer customer) {
        super.update(customer);
    }

    @Override
    public void activateCustomer(Customer customer) {
        super.update(customer);
    }

    public static void main(String[] args) {
        CustomerDAOImpl dao = new CustomerDAOImpl();
        List<Customer> list = dao.findAll();
        for (Customer customer : list) {
           System.out.println(customer.getFullName());
        }
    }
}
