package com.biblio.dao.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dto.request.SearchBookRequest;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.enumeration.EBookMetadataStatus;

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
    public List<BookTemplate> findByCriteria(SearchBookRequest request) {
        StringBuilder jpql = new StringBuilder("SELECT bt FROM BookTemplate bt "
                + "JOIN FETCH bt.books b "
                + "LEFT JOIN FETCH bt.mediaFiles "
                + "WHERE b.id = (SELECT MIN(b2.id) FROM Book b2 WHERE b2.bookTemplate.id = bt.id) AND bt.status = 'ON_SALE' AND b.sellingPrice >= :minPrice AND b.sellingPrice <= :maxPrice ");

        Map<String, Object> params = new HashMap<>();
        params.put("minPrice", Double.valueOf(request.getMinPrice()));
        params.put("maxPrice", Double.valueOf(request.getMaxPrice()));

        jpql.append(" AND (");
        String[] searchTerms = request.getTitle().split("\\s+");
        for (int i = 0; i < searchTerms.length; i++) {
            jpql.append("b.title LIKE :title").append(i);
            params.put("title" + i, "%" + searchTerms[i] + "%");
            if (i < searchTerms.length - 1) {
                jpql.append(" OR ");
            }
        }
        jpql.append(")");

        if (request.getCategoryId() != null) {
            jpql.append(" AND b.subCategory.category.id = :categoryId");
            params.put("categoryId", request.getCategoryId());
        }

        String orderByClause = null;
        String sortBy = request.getSortBy();
        if (sortBy != null && !sortBy.isEmpty()) {
            switch (sortBy) {
                case "priceAsc":
                    orderByClause = " ORDER BY b.sellingPrice ASC";
                    break;
                case "priceDesc":
                    orderByClause = " ORDER BY b.sellingPrice DESC";
                    break;
                case "newest":
                    orderByClause = " ORDER BY b.publicationDate DESC";
                    break;
                case "bestseller":
                    orderByClause = " ORDER BY b.sales DESC";
                    break;
                default:
                    break;
            }
        }

        if (orderByClause != null) {
            jpql.append(orderByClause);
        }

        return super.findByJPQLPaginated(jpql.toString(), request.getPageNumber(), request.getPerPage(), params);
    }

    @Override
    public Long countByCriteria(SearchBookRequest request) {
        StringBuilder jpql = new StringBuilder("SELECT count(DISTINCT bt.id) FROM BookTemplate bt "
                + "JOIN bt.books b "
                + "WHERE b.id = (SELECT MIN(b2.id) FROM Book b2 WHERE b2.bookTemplate.id = bt.id) AND bt.status = 'ON_SALE' AND "
                + "b.sellingPrice >= :minPrice AND b.sellingPrice <= :maxPrice AND (");

        Map<String, Object> params = new HashMap<>();
        params.put("minPrice", Double.valueOf(request.getMinPrice()));
        params.put("maxPrice", Double.valueOf(request.getMaxPrice()));

        String[] searchTerms = request.getTitle().split("\\s+");
        for (int i = 0; i < searchTerms.length; i++) {
            jpql.append("b.title LIKE :title").append(i);
            params.put("title" + i, "%" + searchTerms[i] + "%");
            if (i < searchTerms.length - 1) {
                jpql.append(" OR ");
            }
        }
        jpql.append(")");

        if (request.getCategoryId() != null) {
            jpql.append(" AND b.subCategory.category.id = :categoryId");
            params.put("categoryId", request.getCategoryId());
        }

        return super.countByJPQL(jpql.toString(), params);
    }

    @Override
    public Long countSoldById(Long bookTemplateId) {
        String jpql = "SELECT COUNT(b) FROM Book b " +
                "JOIN b.bookTemplate bt " +
                "WHERE bt.id = :bookTemplateId " +
                "AND b.bookMetadata.status = :status";

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplateId", bookTemplateId);
        params.put("status", EBookMetadataStatus.SOLD);

        return super.countByJPQL(jpql, params);
    }

    @Override
    public Long countInstockById(Long bookTemplateId) {
        String jpql = "SELECT COUNT(b) FROM Book b " +
                "JOIN b.bookTemplate bt " +
                "WHERE bt.id = :bookTemplateId " +
                "AND b.bookMetadata.status = :status";

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplateId", bookTemplateId);
        params.put("status", EBookMetadataStatus.IN_STOCK);

        return super.countByJPQL(jpql, params);
    }

    @Override
    public Long countAll() {
        return super.countByJPQL("SELECT count(DISTINCT bt.id) FROM BookTemplate bt WHERE bt.status != 'OUT_OF_STOCK'");
    }

    public static void main(String[] args) {
        BookTemplateDAOImpl dao = new BookTemplateDAOImpl();
//        System.out.println(dao.findByCriteria());
    }

}
