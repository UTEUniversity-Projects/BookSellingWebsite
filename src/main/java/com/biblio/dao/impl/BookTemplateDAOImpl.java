package com.biblio.dao.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.dao.IBookTemplateDAO;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.MediaFile;
import com.biblio.enumeration.EBookMetadataStatus;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

public class BookTemplateDAOImpl extends GenericDAOImpl<BookTemplate> implements IBookTemplateDAO {
    private BookDAOImpl bookDAO = new BookDAOImpl();
    private AuthorDAOImpl authorDAO = new AuthorDAOImpl();
    private TranslatorDAOImpl translatorDAO = new TranslatorDAOImpl();
    private ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
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

    public static void main(String[] args) {
        BookTemplateDAOImpl dao = new BookTemplateDAOImpl();
        BookTemplate book = dao.findOneForDetails(3L);
        System.out.println(book.getId());
    }
}
