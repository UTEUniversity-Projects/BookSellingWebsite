package com.biblio.dao;

import com.biblio.entity.Author;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.List;

public interface IAuthorDAO {

    List<Author> findAll();

    Author findById(Long id);

    List<Author> findByBookTemplate(BookTemplate bookTemplate);

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Long id);

}
