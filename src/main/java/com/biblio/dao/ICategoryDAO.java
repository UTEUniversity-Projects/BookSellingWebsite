package com.biblio.dao;

import com.biblio.dto.response.CategoryBookCountResponse;
import com.biblio.entity.Category;

import java.util.List;

public interface ICategoryDAO {

    List<Category> findAll();

    Category findById(Long id);

    Category findBySubCategoryId(Long id);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);

    List<CategoryBookCountResponse> countBookPerCategory();

}
