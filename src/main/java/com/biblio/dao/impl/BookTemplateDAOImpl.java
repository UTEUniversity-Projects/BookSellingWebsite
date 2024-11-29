package com.biblio.dao.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EOrderStatus;

import java.time.LocalDateTime;
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
    public List<BookTemplate> findByCriteria(String title, Long categoryId, String sortBy, int pageNumber) {
        StringBuilder jpql = new StringBuilder("SELECT DISTINCT bt FROM BookTemplate bt "
                + "JOIN bt.books b "
                + "LEFT JOIN FETCH bt.mediaFiles "
                + "WHERE b.title LIKE :title");

        Map<String, Object> params = new HashMap<>();
        params.put("title", "%" + title + "%");

        if (categoryId != null) {
            jpql.append(" AND b.subCategory.category.id = :categoryId");
            params.put("categoryId", categoryId);
        }

        String orderByClause = null;
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

        return super.findByJPQLPaginated(jpql.toString(), pageNumber, 8, params);
    }

    @Override
    public Long countByCriteria(String title, Long categoryId, String sortBy) {
        StringBuilder jpql = new StringBuilder("SELECT count(DISTINCT bt.id) FROM BookTemplate bt "
                + "JOIN bt.books b "
                + "WHERE b.title LIKE :title");

        Map<String, Object> params = new HashMap<>();
        params.put("title", "%" + title + "%");

        if (categoryId != null) {
            jpql.append(" AND b.subCategory.category.id = :categoryId");
            params.put("categoryId", categoryId);
        }

        String orderByClause = null;
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
        return super.count();
    }

    @Override
    public Long calculateValueBooksSoldInRange(Long id, EOrderStatus status, LocalDateTime from, LocalDateTime to) {
        String sql = """
                    SELECT SUM(value_books) revenue
                    FROM (
                        SELECT oi.order_id, SUM(value_order_item) value_books
                        FROM (
                            SELECT oib.order_item_id, SUM(books.selling_price) value_order_item
                            FROM (
                                SELECT b.id, b.selling_price
                                FROM book_template bt
                                LEFT JOIN book b
                                ON bt.id = b.book_template_id
                                WHERE bt.id = :bookTemplateId
                            ) books
                            JOIN order_item_books oib
                            ON books.id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_bi
                        JOIN order_item oi
                        ON order_bi.order_item_id = oi.id
                        GROUP BY oi.order_id
                    ) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus AND (o.order_date BETWEEN :startDate AND :endDate);
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplateId", id);
        params.put("orderStatus", status.name());
        params.put("startDate", from.toString());
        params.put("endDate", to.toString());

        return (long) Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    public static void main(String[] args) {
        BookTemplateDAOImpl dao = new BookTemplateDAOImpl();
        System.out.println(dao.countInstockById(33L));
    }

}
