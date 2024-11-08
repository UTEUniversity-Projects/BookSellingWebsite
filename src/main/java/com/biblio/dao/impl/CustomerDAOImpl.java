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
       return super.findAll();
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

//    }
}
