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

//    public static void main(String[] args) {
//        List<Customer> list = new CustomerDAOImpl().findAll();
//        for (Customer customer : list) {
//            Set<Address> addresses = customer.getAddresses();
//            for (Address address : addresses) {
//                System.out.println(address.getProvince());
//            }
//            System.out.println(customer.getId());
//        }
//
//    }
}
