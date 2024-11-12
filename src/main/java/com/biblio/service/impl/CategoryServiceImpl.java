package com.biblio.service.impl;

import com.biblio.dao.ICategoryDAO;

import com.biblio.dto.response.CategoryGetListResponse;
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
    public List<CategoryResponse> findAll() {
        List<CategoryResponse> list = new ArrayList<CategoryResponse>();
        for (Category category : categoryDAO.findAll()) {
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
