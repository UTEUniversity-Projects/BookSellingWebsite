package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.entity.Book;
import com.biblio.service.IBookService;

import javax.inject.Inject;
import java.util.List;

public class BookServiceImpl implements IBookService {
    @Inject
    IBookDAO bookDAO;

    public List<Book> getBooks() {
        return bookDAO.findAll();
    }
}
