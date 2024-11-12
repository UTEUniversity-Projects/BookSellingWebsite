package com.biblio.dao.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.entity.Book;
import com.biblio.entity.Order;

import java.util.List;

public class BookDAOImpl extends GenericDAOImpl<Book> implements IBookDAO {
    public BookDAOImpl() {
        super(Book.class);
    }

    @Override
    public List<Book> findAll() {
        return super.findAll();
    }

    @Override
    public Book findById(Long id) {
        return super.findById(id);
    }

    public static void main(String[] args) {
        BookDAOImpl dao = new BookDAOImpl();
        List<Book> list = dao.findAll();
        for (Book book : list) {
            System.out.println(book.getSellingPrice());
        }
    }
}
