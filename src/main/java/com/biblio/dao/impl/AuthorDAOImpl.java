package com.biblio.dao.impl;

import com.biblio.dao.IAuthorDAO;
import com.biblio.dto.request.AuthorCreateRequest;
import com.biblio.dto.request.AuthorDeleteRequest;
import com.biblio.dto.request.AuthorUpdateRequest;
import com.biblio.entity.Author;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EOrderStatus;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Slf4j
public class AuthorDAOImpl extends GenericDAOImpl<Author> implements IAuthorDAO {

    public AuthorDAOImpl() {
        super(Author.class);
    }

    @Override
    public Author findEntityById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Author> findEntityAll() {
        return super.findAll();
    }

    @Override
    public List<Author> findByBookTemplate(BookTemplate bookTemplate) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT a ")
                .append("FROM Author a ")
                .append("JOIN a.bookTemplates bt ")
                .append("WHERE bt = :bookTemplate");

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplate", bookTemplate);
        return super.findByJPQL(jpql.toString(), params);
    }

    @Override
    public List<String> findTopSubCategory(Long id) {
        String sql = """
                    SELECT sc.name
                    FROM (
                        SELECT b.sub_category_id, COUNT(DISTINCT ab_template.book_template_id) unique_book_template
                        FROM (
                            SELECT abt.book_template_id
                            FROM author_book_template abt
                            WHERE abt.author_id = :authorId
                        ) ab_template
                        JOIN book b
                        ON ab_template.book_template_id = b.book_template_id
                        GROUP BY b.sub_category_id
                        ORDER BY unique_book_template DESC) sc_book_template
                    JOIN sub_category sc
                    ON sc_book_template.sub_category_id = sc.id
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);

        return super.findByNativeQuery(sql, params, String.class);
    }

    @Override
    public void createAuthor(AuthorCreateRequest authorCreateRequest) {
        String sql = "INSERT INTO author (name, avatar, introduction, join_at) " +
                "VALUES (:name, :avatar, :introduction, :joinAt)";

        Map<String, Object> params = new HashMap<>();
        params.put("name", authorCreateRequest.getName());
        params.put("avatar", authorCreateRequest.getAvatar());
        params.put("introduction", authorCreateRequest.getIntroduction());
        params.put("joinAt", authorCreateRequest.getJoinAt());

        super.executeNativeQuery(sql, params);

    }

    @Override
    public void updateAuthor(AuthorUpdateRequest authorUpdateRequest) {
        String sql = "UPDATE author SET " +
                "name = :name, " +
                "avatar = :avatar, " +
                "introduction = :introduction " +
                "WHERE id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("name", authorUpdateRequest.getName());
        params.put("avatar", authorUpdateRequest.getAvatar());
        params.put("introduction", authorUpdateRequest.getIntroduction());
        params.put("id", authorUpdateRequest.getId());

        super.executeNativeQuery(sql, params);
    }

    @Override
    public void deleteAuthor(AuthorDeleteRequest authorDeleteRequest) {
        String sql = "DELETE FROM author a WHERE a.id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", authorDeleteRequest.getId());

        super.executeNativeQuery(sql, params);
    }

    @Override
    public Integer countBooksAll(Long id) {
        String jpql = "SELECT COUNT(*) author_works FROM author_book_template abt WHERE abt.author_id = :authorId";

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);

        return Math.toIntExact(super.countByNativeQuery(jpql, params));
    }

    @Override
    public Integer countBooksInRangeByStatus(Long id, LocalDateTime from, LocalDateTime to, EBookMetadataStatus bookStatus, EOrderStatus orderStatus) {
        String sql = """
                    SELECT SUM(books_count) amount
                    FROM (
                        SELECT order_id, SUM(total_books) books_count
                        FROM (
                            SELECT oib.order_item_id, COUNT(*) AS total_books
                            FROM (
                                SELECT books.id book_id
                                FROM (
                                    SELECT b.id, b.book_metadata_id
                                    FROM (
                                        SELECT abt.book_template_id
                                        FROM author_book_template abt
                                        WHERE abt.author_id = :authorId
                                    ) ab_template
                                    JOIN book b
                                    ON ab_template.book_template_id = b.book_template_id
                                ) books
                                JOIN book_metadata bm
                                ON books.book_metadata_id = bm.id
                                WHERE bm.status = :bookStatus
                            ) bm_books
                            JOIN order_item_books oib
                            ON bm_books.book_id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id
                        GROUP BY oi.order_id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus AND (o.order_date BETWEEN :startDate AND :endDate)
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("bookStatus", bookStatus.name());
        params.put("orderStatus", orderStatus.name());
        params.put("startDate", from.toString());
        params.put("endDate", to.toString());

        return Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Integer countBooksByStatus(Long id, EBookMetadataStatus status) {
        String sql = """
                    SELECT COUNT(*) author_books
                    FROM (
                        SELECT b.book_metadata_id
                        FROM (
                            SELECT abt.book_template_id
                            FROM author_book_template abt
                            WHERE abt.author_id = :authorId
                        ) ab_template
                        JOIN book b
                        ON ab_template.book_template_id = b.book_template_id
                    ) books
                    JOIN book_metadata bm
                    ON books.book_metadata_id = bm.id
                    WHERE bm.status = :bookStatus
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("bookStatus", status.name());

        return Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Integer countBooksByOrderStatus(Long id, EOrderStatus status) {
        String sql = """
                    SELECT SUM(books_count) amount
                    FROM (
                        SELECT order_id, SUM(total_books) books_count
                        FROM (
                            SELECT oib.order_item_id, COUNT(*) AS total_books
                            FROM (
                                SELECT books.id book_id
                                FROM (
                                    SELECT b.id, b.book_metadata_id
                                    FROM (
                                        SELECT abt.book_template_id
                                        FROM author_book_template abt
                                        WHERE abt.author_id = :authorId
                                    ) ab_template
                                    JOIN book b
                                    ON ab_template.book_template_id = b.book_template_id
                                ) books
                                JOIN book_metadata bm
                                ON books.book_metadata_id = bm.id
                            ) bm_books
                            JOIN order_item_books oib
                            ON bm_books.book_id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id
                        GROUP BY oi.order_id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("orderStatus", status.name());

        return Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Integer countOrdersAll(Long id) {
        String sql = """
                    SELECT COUNT(*) amount
                    FROM (
                        SELECT order_id, total_books
                        FROM (
                            SELECT oib.order_item_id, COUNT(*) AS total_books
                            FROM (
                                SELECT b.id
                                FROM (
                                    SELECT abt.book_template_id
                                    FROM author_book_template abt
                                    WHERE abt.author_id = :authorId
                                ) ab_template
                                JOIN book b
                                ON ab_template.book_template_id = b.book_template_id
                            ) books
                            JOIN order_item_books oib
                            ON books.id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);

        return Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Integer countOrdersInRangeByStatus(Long id, LocalDateTime from, LocalDateTime to, EOrderStatus status) {
        String sql = """
                    SELECT COUNT(*) amount
                    FROM (
                        SELECT order_id, total_books
                        FROM (
                            SELECT oib.order_item_id, COUNT(*) AS total_books
                            FROM (
                                SELECT b.id
                                FROM (
                                    SELECT abt.book_template_id
                                    FROM author_book_template abt
                                    WHERE abt.author_id = :authorId
                                ) ab_template
                                JOIN book b
                                ON ab_template.book_template_id = b.book_template_id
                            ) books
                            JOIN order_item_books oib
                            ON books.id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus AND (o.order_date BETWEEN :startDate AND :endDate)
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("orderStatus", status.name());
        params.put("startDate", from.toString());
        params.put("endDate", to.toString());

        return Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Integer countOrdersByStatus(Long id, EOrderStatus status) {
        String sql = """
                    SELECT COUNT(*) amount
                    FROM (
                        SELECT order_id, total_books
                        FROM (
                            SELECT oib.order_item_id, COUNT(*) AS total_books
                            FROM (
                                SELECT b.id
                                FROM (
                                    SELECT abt.book_template_id
                                    FROM author_book_template abt
                                    WHERE abt.author_id = :authorId
                                ) ab_template
                                JOIN book b
                                ON ab_template.book_template_id = b.book_template_id
                            ) books
                            JOIN order_item_books oib
                            ON books.id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("orderStatus", status.name());

        return Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Long calculateValueBooksSold(Long id) {
        String sql = """
                    SELECT SUM(selling_price) price
                    FROM (
                       SELECT b.book_metadata_id, b.selling_price
                       FROM (
                           SELECT abt.book_template_id
                           FROM author_book_template abt
                           WHERE abt.author_id = :authorId
                       ) ab_template
                       JOIN book b
                       ON ab_template.book_template_id = b.book_template_id
                    ) books
                    JOIN book_metadata bm
                    ON books.book_metadata_id = bm.id
                    WHERE bm.status = :bookStatus
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("bookStatus", EBookMetadataStatus.SOLD.name());

        return (long) Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Long calculateValueBooksSoldInRange(Long id, LocalDateTime from, LocalDateTime to) {
        String sql = """
                    SELECT SUM(sum_books) amount
                    FROM (
                        SELECT oi.order_id, SUM(sum_order_item) sum_books
                        FROM (
                            SELECT oib.order_item_id, COUNT(*) AS total_books, SUM(selling_price) sum_order_item
                            FROM (
                                SELECT b.id, b.selling_price
                                FROM (
                                    SELECT abt.book_template_id
                                    FROM author_book_template abt
                                    WHERE abt.author_id = :authorId
                                ) ab_template
                                JOIN book b
                                ON ab_template.book_template_id = b.book_template_id
                            ) books
                            JOIN order_item_books oib
                            ON books.id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id
                        GROUP BY oi.order_id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus AND (o.order_date BETWEEN :startDate AND :endDate);
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("orderStatus", EOrderStatus.COMPLETE_DELIVERY.name());
        params.put("startDate", from.toString());
        params.put("endDate", to.toString());

        return (long) Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Long calculateValueOrdersSoldByStatus(Long id, EOrderStatus status) {
        String sql = """
                    SELECT SUM(sum_books) amount
                    FROM (
                        SELECT order_id, SUM(sum_order_item) sum_books
                        FROM (
                            SELECT oib.order_item_id, SUM(books.selling_price) sum_order_item
                            FROM (
                                SELECT b.id, b.selling_price
                                FROM (
                                    SELECT abt.book_template_id
                                    FROM author_book_template abt
                                    WHERE abt.author_id = :authorId
                                ) ab_template
                                JOIN book b
                                ON ab_template.book_template_id = b.book_template_id
                            ) books
                            JOIN order_item_books oib
                            ON books.id = oib.book_id
                            GROUP BY oib.order_item_id
                        ) order_tb
                        JOIN order_item oi
                        ON order_tb.order_item_id = oi.id
                        GROUP BY oi.order_id) orders
                    JOIN `order` o
                    ON orders.order_id = o.id
                    WHERE o.status = :orderStatus
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);
        params.put("orderStatus", status.name());

        return (long) Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    @Override
    public Double calculateAverageRating(Long id) {
        String sql = """
                    SELECT COALESCE(AVG(review.rate), 0) AS average_amount
                    FROM (
                        SELECT abt.book_template_id
                        FROM author_book_template abt
                        WHERE abt.author_id = :authorId
                    ) ab_template
                    JOIN review
                    ON ab_template.book_template_id = review.book_template_id;
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("authorId", id);

        return (double) Math.toIntExact(super.countByNativeQuery(sql, params));
    }

    public static void main(String[] args) {
        AuthorDAOImpl dao = new AuthorDAOImpl();
        Integer test = dao.countOrdersByStatus(1L, EOrderStatus.COMPLETE_DELIVERY);
        System.out.println(test);
        System.out.println(EOrderStatus.COMPLETE_DELIVERY.name());
    }
}
