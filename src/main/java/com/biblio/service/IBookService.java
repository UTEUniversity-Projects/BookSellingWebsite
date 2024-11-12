package com.biblio.service;

import com.biblio.dto.response.BookGetListResponse;
import com.biblio.dto.response.BookResponse;

import java.util.List;

public interface IBookService {
    List<BookGetListResponse> findAll();
    BookResponse findById(Long id);
}
