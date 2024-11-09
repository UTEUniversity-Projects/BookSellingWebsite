package com.biblio.dao;

import com.biblio.entity.Book;

import java.util.List;

public interface IBookDAO {
    public List<Book> findAll();
}
