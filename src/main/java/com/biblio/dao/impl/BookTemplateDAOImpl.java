package com.biblio.dao.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import java.util.*;

public class BookTemplateDAOImpl extends GenericDAOImpl<BookTemplate> implements IBookTemplateDAO {
    private final BookDAOImpl bookDAO = new BookDAOImpl();
    private final AuthorDAOImpl authorDAO = new AuthorDAOImpl();
    private final TranslatorDAOImpl translatorDAO = new TranslatorDAOImpl();
    private final ReviewDAOImpl reviewDAO = new ReviewDAOImpl();

    public BookTemplateDAOImpl() {
        super(BookTemplate.class);
    }

    @Override
    public BookTemplate findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<BookTemplate> findAll() {
        return super.findAll();
    }

    @Override
    public List<BookTemplate> findAllForManagement() {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT bt ")
                .append("FROM BookTemplate bt ")
                .append("LEFT JOIN FETCH bt.mediaFiles m");

        List<BookTemplate> bookTemplates = super.findAll(jpql.toString());

        for (BookTemplate bookTemplate : bookTemplates) {
            Set<Book> books = new HashSet<>(bookDAO.findByBookTemplate(bookTemplate));
            bookTemplate.setBooks(books);
        }
        return bookTemplates;
    }

    @Override
    public List<BookTemplate> findAllForHome() {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT bt ")
                .append("FROM BookTemplate bt ")
                .append("LEFT JOIN FETCH bt.reviews r")
                .append("LEFT JOIN FETCH bt.mediaFiles m");

        List<BookTemplate> bookTemplates = super.findAll(jpql.toString());

        for (BookTemplate bookTemplate : bookTemplates) {
            Set<Book> books = new HashSet<>(bookDAO.findByBookTemplate(bookTemplate));
            bookTemplate.setBooks(books);
        }
        return bookTemplates;
    }

    @Override
    public BookTemplate findOneForDetails(Long id) {
        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT DISTINCT bt ")
                .append("FROM BookTemplate bt ")
                .append("LEFT JOIN FETCH bt.mediaFiles m")
                .append("LEFT JOIN FETCH bt.publisher p ")
                .append("WHERE bt.id = :id");

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        BookTemplate bookTemplate = super.findSingleByJPQL(jpql.toString(), params);
        bookTemplate.setAuthors(new HashSet<>(authorDAO.findByBookTemplate(bookTemplate)));
        bookTemplate.setTranslators(new HashSet<>(translatorDAO.findByBookTemplate(bookTemplate)));
        bookTemplate.setBooks(new HashSet<>(bookDAO.findByBookTemplate(bookTemplate)));
        bookTemplate.setReviews(new HashSet<>(reviewDAO.findByBookTemplate(bookTemplate)));
        return bookTemplate;
    }

    @Override
    public List<BookTemplate> findByTitle(String title) {
        String jpql = "SELECT DISTINCT bt FROM BookTemplate bt "
                + "JOIN bt.books b "
                + "LEFT JOIN FETCH bt.mediaFiles "
                + "WHERE b.title LIKE :title";

        Map<String, Object> params = new HashMap<>();
        params.put("title", "%" + title + "%");

        return super.findByJPQL(jpql, params);
    }


    public static void main(String[] args) {
        BookTemplateDAOImpl dao = new BookTemplateDAOImpl();
        System.out.println(dao.findOneForDetails(1L).getBooks().size());
    }

}
