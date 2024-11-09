package com.biblio.dao.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;

import java.util.List;

public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements ICustomerDAO {
    public CustomerDAOImpl() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findAll() {
//        String jpql = "SELECT c FROM Customer c";
//        return super.findAll(jpql);
        return super.findAll();
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

    public static void main(String[] args) {
//        Customer customer = new Customer();
//        customer.setId(1L);
//        customer.getAccount().setStatus(EAccountStatus.INACTIVE);
//        new CustomerDAOImpl().deactivateCustomer(customer);
        long startTime = System.nanoTime();
        List<Customer> list = new CustomerDAOImpl().findAll();
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Tính thời gian chạy
        System.out.println("Time taken to execute query: " + duration / Math.pow(10, 9) + " seconds");
        for (Customer customer : list) {
//            Set<Address> addresses = customer.getAddresses();
//            for (Address address : addresses) {
//                System.out.println(address.getProvince());
//            }
            System.out.println(customer.getId());
        }
    }
}
