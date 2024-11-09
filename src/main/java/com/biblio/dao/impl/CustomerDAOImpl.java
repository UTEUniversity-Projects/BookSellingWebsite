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
        long startTime = System.nanoTime();
//        Customer customer = new Customer();
//        customer.setId(1L);
//        customer.getAccount().setStatus(EAccountStatus.INACTIVE);
//        CustomerDAOImpl dao = new CustomerDAOImpl();
//        dao.deactivateCustomer(customer);
        List<Customer> list = new CustomerDAOImpl().findAll();
        for (Customer customer : list) {
//            Set<Address> addresses = customer.getAddresses();
//            for (Address address : addresses) {
//                System.out.println(address.getProvince());
//            }
           System.out.println(customer.getId());
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Tính thời gian chạy
        System.out.println("Time taken to execute query: " + duration / Math.pow(10, 9) + " seconds");
    }
}
