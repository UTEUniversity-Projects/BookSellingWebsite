package com.biblio.dao;

import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.List;

public interface IBookDAO {

    List<Book> findAll();

    Book findById(Long id);

    List<Book> findByBookTemplate(BookTemplate bookTemplate);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

}
