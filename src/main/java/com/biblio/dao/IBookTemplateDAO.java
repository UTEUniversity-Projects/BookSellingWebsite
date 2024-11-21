package com.biblio.dao;

import com.biblio.entity.BookTemplate;

import java.util.List;

public interface IBookTemplateDAO {

    BookTemplate findById(Long id);

    List<BookTemplate> findAll();

    List<BookTemplate> findAllForManagement();

    List<BookTemplate> findAllForHome();

    BookTemplate findOneForDetails(Long id);

    List<BookTemplate> findByTitle(String title);

}
