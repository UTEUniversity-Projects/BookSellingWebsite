package com.biblio.dao;

import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.List;

public interface IBookTemplateDAO {
    BookTemplate findById(Long id);

    List<BookTemplate> findAll();

    List<BookTemplate> findAllForManagement();

    List<BookTemplate> findAllForHome();

    BookTemplate findOneForDetails(Long id);
}
