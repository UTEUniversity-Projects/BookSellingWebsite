package com.biblio.dao;

import com.biblio.entity.BookTemplate;
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

    Long calculateValueBooksSoldInRange(Long id, EOrderStatus status, LocalDateTime from, LocalDateTime to);

}
