package com.biblio.service;

import com.biblio.dto.request.CategoryRequest;
import com.biblio.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
    void addCategory(CategoryRequest categoryRequest);
    void updateCategory(CategoryRequest categoryRequest);
    void deleteCategory(Long id);
}
