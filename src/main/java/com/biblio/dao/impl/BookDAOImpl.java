package com.biblio.dao.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.HashMap;
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
    public List<Book> findByBookTemplate(BookTemplate bookTemplate) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT b ")
                .append("FROM Book b ")
                .append("JOIN FETCH b.bookMetadata mt ")
                .append("JOIN FETCH b.subCategory s ")
                .append("JOIN FETCH s.category c ")
                .append("WHERE b.bookTemplate = :bookTemplate");

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplate", bookTemplate);
        return super.findByJPQL(jpql.toString(), params);
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
