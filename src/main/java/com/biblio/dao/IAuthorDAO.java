package com.biblio.dao;

import com.biblio.dto.request.AuthorCreateRequest;
import com.biblio.dto.request.AuthorDeleteRequest;
import com.biblio.dto.request.AuthorUpdateRequest;
import com.biblio.entity.Author;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EOrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface IAuthorDAO {
    Author findEntityById(Long id);
    List<Author> findEntityAll();
    List<Author> findByBookTemplate(BookTemplate bookTemplate);
    List<String> findTopSubCategory(Long id);
    void createAuthor(AuthorCreateRequest authorCreateRequest);
    void updateAuthor(AuthorUpdateRequest authorUpdateRequest);
    void deleteAuthor(AuthorDeleteRequest authorDeleteRequest);
    Integer countBooksAll(Long id);
    Integer countBooksByStatus(Long id, EBookMetadataStatus status);
    Integer countBooksByOrderStatus(Long id, EOrderStatus orderStatus);
    Integer countBooksInRangeByStatus(Long id, LocalDateTime from, LocalDateTime to, EBookMetadataStatus bookStatus, EOrderStatus orderStatus);
    Integer countOrdersAll(Long id);
    Integer countOrdersByStatus(Long id, EOrderStatus status);
    Integer countOrdersInRangeByStatus(Long id, LocalDateTime from, LocalDateTime to, EOrderStatus status);
    Long calculateValueBooksSold(Long id);
    Long calculateValueBooksSoldInRange(Long id, LocalDateTime from, LocalDateTime to);
    Long calculateValueOrdersSoldByStatus(Long id, EOrderStatus status);
    Double calculateAverageRating(Long id);
}
