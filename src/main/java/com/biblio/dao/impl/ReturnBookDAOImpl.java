package com.biblio.dao.impl;

import com.biblio.dao.IReturnBookDAO;
import com.biblio.entity.ReturnBook;

import java.util.HashMap;
import java.util.Map;

public class ReturnBookDAOImpl extends GenericDAOImpl<ReturnBook> implements IReturnBookDAO {

    public ReturnBookDAOImpl() {
        super(ReturnBook.class);
    }

    @Override
    public ReturnBook findByOrderId(Long orderId) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT r ")
                .append("FROM ReturnBook r ")
                .append("LEFT JOIN FETCH r.proof p ")
                .append("WHERE r.order.id = :orderId");

        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);

        return super.findSingleByJPQL(jpql.toString(), params);
    }
  
    @Override
    public ReturnBook save(ReturnBook returnBook) {
        // Call the save method from the GenericDAOImpl
        super.save(returnBook);  // Using the inherited save method
        return returnBook;
    }

    public static void main(String[] args) {
        ReturnBookDAOImpl dao = new ReturnBookDAOImpl();
        ReturnBook returnBook = dao.findByOrderId(2L);
        System.out.println(returnBook);
    }
}
