package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;

import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.dto.response.BookResponse;
import com.biblio.entity.Book;
import com.biblio.mapper.BookMapper;
import com.biblio.mapper.BookTemplateMapper;
import com.biblio.service.IBookService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements IBookService {
    @Inject
    private IBookDAO bookDAO;

    @Override
    public List<BookResponse> findAll() {
        return List.of();
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
