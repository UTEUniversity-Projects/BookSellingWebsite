package com.biblio.service.impl;

import com.biblio.dao.IReturnBookDAO;
import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.ReturnBook;
import com.biblio.mapper.ReturnBookMapper;
import com.biblio.service.IReturnBookService;

import com.biblio.entity.ReturnBook;
import com.biblio.service.IReturnBookService;
import com.biblio.dao.IReturnBookDAO;


import javax.inject.Inject;

public class ReturnBookServiceImpl implements IReturnBookService {

    @Inject
    IReturnBookDAO returnBookDAO;

    @Override
    public ReturnBookManagementResponse findReturnBookByOrderId(Long orderId) {
        ReturnBook returnBook = returnBookDAO.findByOrderId(orderId);
        return ReturnBookMapper.toReturnBookManagementResponse(returnBook);
    }

    @Override
    public void save(ReturnBook returnBook) {
        if (returnBook == null) {
            throw new IllegalArgumentException("ReturnBook cannot be null.");
        }
        if (returnBook.getReason() == null) {
            throw new IllegalArgumentException("Reason for returning the book cannot be null.");
        }
        if (returnBook.getDescription() == null || returnBook.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        if (returnBook.getCreatedAt() == null) {
            throw new IllegalArgumentException("CreatedAt timestamp must be set.");
        }

        // Save the entity using the DAO
        returnBookDAO.save(returnBook);
    }
}