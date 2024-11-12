package com.biblio.service;

import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookResponse;

import java.util.List;

public interface IBookService {

    List<BookResponse> findAll();
    BookResponse findById(Long id);
    void addBook(BookRequest bookRequest);
    void updateBook(BookRequest bookRequest);
    void deleteBook(Long id);
}
