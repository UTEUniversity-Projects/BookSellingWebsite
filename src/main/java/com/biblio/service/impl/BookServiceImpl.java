package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dao.IOrderDAO;
import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookResponse;
import com.biblio.service.IBookService;

import javax.inject.Inject;
import java.util.List;

public class BookServiceImpl implements IBookService {
    @Inject
    private IBookDAO bookDAO;

    @Inject
    private IBookTemplateDAO bookTemplateDAO;

    @Inject
    private IOrderDAO orderDAO;

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
