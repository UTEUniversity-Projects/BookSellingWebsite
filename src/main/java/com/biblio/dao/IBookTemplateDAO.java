package com.biblio.dao;

import com.biblio.entity.BookTemplate;

import java.util.List;

public interface IBookTemplateDAO {

    BookTemplate findById(Long id);

    List<BookTemplate> findAll();

    List<BookTemplate> findAllForManagement();

    List<BookTemplate> findAllForHome();

    BookTemplate findOneForDetails(Long id);

    List<BookTemplate> findByCriteria(String title, Long categoryId, String sortBy, int pageNumber);

    long countByCriteria(String title, Long categoryId, String sortBy);

    Long countSoldById(Long id);

    Long countInstockById(Long id);

}
