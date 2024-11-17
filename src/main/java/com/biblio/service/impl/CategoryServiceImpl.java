package com.biblio.service.impl;

import com.biblio.dao.ICategoryDAO;

import com.biblio.dto.response.CategoryGetListResponse;
import com.biblio.dto.response.CategorySidebarResponse;
import com.biblio.entity.Category;
import com.biblio.dto.request.CategoryRequest;
import com.biblio.dto.response.CategoryResponse;
import com.biblio.entity.Category;
import com.biblio.mapper.CategoryMapper;
import com.biblio.service.ICategoryService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    @Inject
    ICategoryDAO categoryDAO;

    @Override
    public List<CategorySidebarResponse> getAllCategorySidebarResponse() {
        List<CategorySidebarResponse> list = new ArrayList<CategorySidebarResponse>();
        for (Category category : categoryDAO.findAll()) {
            list.add(CategoryMapper.toCategorySidebarResponse(category));
        }
        return list;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<CategoryResponse> list = new ArrayList<CategoryResponse>();
        List<Category> categories = categoryDAO.findAll();
        for (Category category : categories) {
            list.add(CategoryMapper.toCategoryResponse(category));
        }
        return list;
    }

    @Override
    public CategoryResponse findById(Long id) {
        return CategoryMapper.toCategoryResponse(categoryDAO.findById(id));
    }

    @Override
    public void addCategory(CategoryRequest categoryRequest) {
        categoryDAO.addCategory(CategoryMapper.toCategoryEntity(categoryRequest));
    }

    @Override
    public void updateCategory(CategoryRequest categoryRequest) {
        categoryDAO.updateCategory(CategoryMapper.toCategoryEntity(categoryRequest));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryDAO.deleteCategory(id);
    }
}
