package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookResponse;
import com.biblio.entity.Book;
import com.biblio.service.IBookService;

import javax.inject.Inject;
import java.util.List;

public class BookServiceImpl implements IBookService {
    @Inject
    IBookDAO bookDAO;

    @Override
    public List<BookResponse> findAll() {
        return List.of();
    }

    @Override
    public BookResponse findById(Long id) {
        return null;
    }

    @Override
    public void addBook(BookRequest bookRequest) {

    }

    @Override
    public void updateBook(BookRequest bookRequest) {

    }

    @Override
    public void deleteBook(Long id) {

    }
}
