package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;

import com.biblio.dto.response.BookResponse;
import com.biblio.entity.Book;
import com.biblio.mapper.BookMapper;
import com.biblio.service.IBookService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements IBookService {
    @Inject
    private IBookDAO bookDAO;

    @Override
    public List<BookGetListResponse> findAll() {
        List<BookGetListResponse> list = new ArrayList<>();
        for (Book book : bookDAO.findAll()) {
            System.out.println("Books: " + book.getTitle());
            list.add(BookMapper.toBookGetListResponse(book));
        }
        return list;
    }

    @Override
    public BookResponse findById(Long id) {
        Book book = bookDAO.findById(id);
        return BookMapper.toBookResponse(book);
    }

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
