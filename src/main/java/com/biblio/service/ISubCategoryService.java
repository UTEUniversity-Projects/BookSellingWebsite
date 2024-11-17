package com.biblio.service;

import com.biblio.dto.request.SubCategoryRequest;
import com.biblio.dto.response.SubCategoryResponse;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategoryResponse> findAll();
    SubCategoryResponse findById(Long id);
    void addSubCategory(SubCategoryRequest subCategoryRequest);
    void updateSubCategory(SubCategoryRequest subCategoryRequest);
    void deleteSubCategory(Long id);
    List<SubCategoryResponse> getAllSubCategoriesById(Long id);
}
