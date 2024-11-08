package com.biblio.dao.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.entity.Account;
import com.biblio.entity.Address;
import com.biblio.entity.Customer;
import org.jboss.jandex.Main;

import java.util.List;
import java.util.Set;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Long> implements ICustomerDAO {
    public CustomerDAOImpl() {
        super(Customer.class);
    }
    @Override
    public List<Customer> findAll() {
       return super.findAll();
    }
    public static void main(String[] args) {
        List<Customer> list = new CustomerDAOImpl().findAll();
        for (Customer customer : list) {
//            Set<Address> addresses = customer.getAddresses();
//            for (Address address : addresses) {
//                System.out.println(address.getProvince());
//            }
            System.out.println(customer.getAccount().getUsername());
        }

    }
}
