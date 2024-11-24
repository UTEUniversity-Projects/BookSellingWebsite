package com.biblio.service.impl;

import com.biblio.entity.ReturnBook;
import com.biblio.service.IReturnBookService;
import com.biblio.dao.IReturnBookDAO;

import javax.inject.Inject;

public class ReturnBookServiceImpl implements IReturnBookService {

    // Use @Inject to inject the DAO layer, this assumes you're using CDI or a DI framework
    @Inject
    private IReturnBookDAO returnBookDao;

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
        returnBookDao.save(returnBook);
    }


    // Optional: Add other methods for update, delete, or find if needed
}
