package com.biblio.dao;

import com.biblio.dto.request.SearchBookRequest;
import com.biblio.entity.BookTemplate;

import java.util.List;

public interface IBookTemplateDAO {

    BookTemplate findById(Long id);

    List<BookTemplate> findAll();

    List<BookTemplate> findAllForManagement();

    List<BookTemplate> findAllForHome();

    BookTemplate findOneForDetails(Long id);

    List<BookTemplate> findByCriteria(SearchBookRequest request);

    Long countByCriteria(SearchBookRequest request);

    Long countSoldById(Long id);

    Long countInstockById(Long id);

    Long countAll();

}
