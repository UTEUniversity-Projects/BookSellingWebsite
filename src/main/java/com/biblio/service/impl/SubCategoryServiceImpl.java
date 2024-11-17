package com.biblio.service.impl;

import com.biblio.dao.ISubCategoryDAO;
import com.biblio.dto.request.SubCategoryRequest;
import com.biblio.dto.response.SubCategoryResponse;
import com.biblio.entity.SubCategory;
import com.biblio.mapper.SubCategoryMapper;
import com.biblio.service.ISubCategoryService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryServiceImpl implements ISubCategoryService {
    @Inject
    ISubCategoryDAO subCategoryDAO;

    @Override
    public List<SubCategoryResponse> findAll() {
        List<SubCategoryResponse> list = new ArrayList<SubCategoryResponse>();
        for (SubCategory subCategory : subCategoryDAO.findAll()) {
            list.add(SubCategoryMapper.toSubCategoryResponse(subCategory));
        }
        return list;
    }

    @Override
    public SubCategoryResponse findById(Long id) {
        return SubCategoryMapper.toSubCategoryResponse(subCategoryDAO.findById(id));
    }

    @Override
    public void addSubCategory(SubCategoryRequest subCategoryRequest) {
        subCategoryDAO.updateSubCategory(SubCategoryMapper.toSubCategoryEntity(subCategoryRequest));
    }

    @Override
    public void updateSubCategory(SubCategoryRequest subCategoryRequest) {
        subCategoryDAO.updateSubCategory(SubCategoryMapper.toSubCategoryEntity(subCategoryRequest));
    }

    @Override
    public void deleteSubCategory(Long id) {
        subCategoryDAO.deleteSubCategory(id);
    }

    @Override
    public List<SubCategoryResponse> getAllSubCategoriesById(Long id) {
        List<SubCategoryResponse> list = new ArrayList<SubCategoryResponse>();
        for (SubCategory subCategory : subCategoryDAO.findByJPQL(id)) {
            list.add(SubCategoryMapper.toSubCategoryResponse(subCategory));
        }
        return list;
    }
}
