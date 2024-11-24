package com.biblio.dao.impl;

import com.biblio.dao.IReturnBookDAO;
import com.biblio.entity.ReturnBook;

public class ReturnBookDAOImpl extends GenericDAOImpl<ReturnBook> implements IReturnBookDAO {
    public ReturnBookDAOImpl() {
        super(ReturnBook.class);
    }

    @Override
    public ReturnBook save(ReturnBook returnBook) {
        // Call the save method from the GenericDAOImpl
        super.save(returnBook);  // Using the inherited save method
        return returnBook;
    }
}
