package com.biblio.dao;

import com.biblio.entity.Author;

import java.util.List;

public interface IAuthorDAO {
    List<Author> findAll();
    Author findById(Long id);
    void addAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(Long id);
}
