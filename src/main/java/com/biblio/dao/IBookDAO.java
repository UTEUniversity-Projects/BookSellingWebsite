package com.biblio.dao;

import com.biblio.entity.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> findAll();
    Book findById(Long id);
    List<Book> findAll();
    Book findById(Long id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}
