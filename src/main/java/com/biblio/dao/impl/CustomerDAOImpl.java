package com.biblio.dao.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.entity.Customer;
import com.biblio.jpaconfig.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements ICustomerDAO {

    public CustomerDAOImpl() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findAll() {
        return super.findAll();
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

    @Override
    public Customer addCustomer(Customer customer) {
        return super.save(customer);
    }

    @Override
    public boolean existsByEmail(String email) {
        String jpql = "SELECT c FROM Customer c WHERE c.emailAddress = :email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        return super.findSingleByJPQL(jpql, params) != null;
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        String jpql = "SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phoneNumber", phoneNumber);
        return super.findSingleByJPQL(jpql, params) != null;
    }

    public void updateSupport_Notification(Customer customer) {
        EntityManager entityManager = JpaConfig.getEntityManager(); // Obtain a new EntityManager
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Customer findByUsername(String username) {
        String jpql = "SELECT c FROM Customer c JOIN FETCH c.addresses WHERE c.account.username = :username";
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        return super.findSingleByJPQL(jpql, params);
    }

}
