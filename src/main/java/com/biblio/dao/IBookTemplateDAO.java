package com.biblio.dao;

import com.biblio.entity.BookTemplate;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EOrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookTemplateDAO {

    BookTemplate findById(Long id);

    List<BookTemplate> findAll();

    List<BookTemplate> findAllForManagement();

    List<BookTemplate> findAllForHome();

    BookTemplate findOneForDetails(Long id);

    List<BookTemplate> findByCriteria(String title, Long categoryId, String sortBy, int pageNumber);

    Long countByCriteria(String title, Long categoryId, String sortBy);

    Long countSoldById(Long id);

    Long countInstockById(Long id);

    Long countAll();

    Integer countOrdersByStatus(Long id, EOrderStatus status);

    Integer countOrdersInRangeByStatus(Long id, LocalDateTime from, LocalDateTime to, EOrderStatus status);

    Integer countBooksInOrderByStatus(Long id, EBookMetadataStatus bookStatus, EOrderStatus orderStatus);

    Integer countBooksInRangeByStatus(Long id, LocalDateTime from, LocalDateTime to, EBookMetadataStatus bookStatus, EOrderStatus orderStatus);

    Long calculateValueBooksSoldInRange(Long id, LocalDateTime from, LocalDateTime to, EOrderStatus status);

    Long calculateValueBooksSold(Long id, EOrderStatus status);

}
