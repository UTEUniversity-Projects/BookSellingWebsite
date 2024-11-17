package com.biblio.dao.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public void addBook(Book book) {
        super.save(book);
    }

    @Override
    public void updateBook(Book book) {
        super.update(book);
    }

    @Override
    public void deleteBook(Long id) {
        super.delete(id);
    }

    public static void main(String[] args) {
//        BookDAOImpl dao = new BookDAOImpl();
//        List<Book> books = dao.findAll();
//
//        Map<BookTemplate, Long> countByTemplate = books.stream()
//                .collect(Collectors.groupingBy(Book::getBookTemplate, Collectors.counting()));
//
//        countByTemplate.forEach((template, count) -> {
//            System.out.println("BookTemplate Name: " + template.getBooks().);
//            System.out.println("Book Count: " + count);
//        });
    }

}
