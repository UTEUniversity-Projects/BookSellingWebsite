package com.biblio.service;

import com.biblio.dto.request.CategoryRequest;
import com.biblio.dto.response.CategoryBookCountResponse;
import com.biblio.dto.response.CategoryResponse;
import com.biblio.dto.response.CategorySidebarResponse;
import com.biblio.dto.response.CategoryTotalBookResponse;

import java.util.List;

public interface ICategoryService {

    List<CategorySidebarResponse> getAllCategorySidebarResponse();

    List<CategoryResponse> getAllCategories();

    CategoryResponse findById(Long id);

    void addCategory(CategoryRequest categoryRequest);

    void updateCategory(CategoryRequest categoryRequest);

    void deleteCategory(Long id);

    List<CategoryBookCountResponse> getAllCategoryBookCount();

    CategoryTotalBookResponse getAllBookCount();
}
