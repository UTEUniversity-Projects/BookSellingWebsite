package com.biblio.dao.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.dto.request.CheckoutItemRequest;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Long findMinBookPrice() {
        String jpql = "SELECT b FROM Book b WHERE b.sellingPrice = (SELECT MIN(b2.sellingPrice) FROM Book b2 JOIN b2.bookMetadata bmd WHERE bmd.status = 'IN_STOCK')";
        Book book = super.findSingleByJPQL(jpql);

        return (long) book.getSellingPrice();
    }

    @Override
    public Long findMaxBookPrice() {
        String jpql = "SELECT b FROM Book b WHERE b.sellingPrice = (SELECT MAX(b2.sellingPrice) FROM Book b2 JOIN b2.bookMetadata bmd WHERE bmd.status = 'IN_STOCK')";

        Book book = super.findSingleByJPQL(jpql);

        return (long) book.getSellingPrice();
    }

    @Override
    public List<Book> findByBookTemplateIdAndQuantity(CheckoutItemRequest request) {
        String jpql = "SELECT b FROM Book b JOIN FETCH b.bookTemplate bt WHERE bt.id = :bookTemplateId AND b.bookMetadata.status = 'IN_STOCK' AND bt.status = 'ON_SALE' ORDER BY FUNCTION('RAND')";
        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplateId", request.getProductId());
        return super.findByJPQLPaginated(jpql, 1, request.getQuantity(), params);
    }


    public static void main(String[] args) {
        BookDAOImpl dao = new BookDAOImpl();
//        List<Book> books = dao.findAll();
//        System.out.println(books);
//
//        Map<BookTemplate, Long> countByTemplate = books.stream()
//                .collect(Collectors.groupingBy(Book::getBookTemplate, Collectors.counting()));
//
//        countByTemplate.forEach((template, count) -> {
//            System.out.println("BookTemplate Name: " + template.getBooks().);
//            System.out.println("Book Count: " + count);
//        });
        CheckoutItemRequest checkoutItemRequest = CheckoutItemRequest.builder()
                .productId(2L)
                .quantity(50)
                .build();
        List<Book> list = dao.findByBookTemplateIdAndQuantity(checkoutItemRequest);

        for (Book book : list) {
            System.out.println(book.toString());
        }

    }

}
