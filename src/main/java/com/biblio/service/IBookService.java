package com.biblio.service;

import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.dto.response.BookResponse;

import java.util.List;

public interface IBookService {
    List<BookCardResponse> getAllBookCardResponse();
    List<BookResponse> findAll();
    BookDetailsResponse getBookDetailsResponse(Long id);
    void addBook(BookRequest bookRequest);
    void updateBook(BookRequest bookRequest);
    void deleteBook(Long id);
}
