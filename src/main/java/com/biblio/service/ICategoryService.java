package com.biblio.service;

import com.biblio.dto.response.CategoryGetListResponse;
import com.biblio.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryGetListResponse> findAll();
}
