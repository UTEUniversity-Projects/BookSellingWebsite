package com.biblio.dao;

import com.biblio.entity.SubCategory;

import java.util.List;

public interface ISubCategoryDAO {

    List<SubCategory> findAll();

    SubCategory findById(Long id);

    void addSubCategory(SubCategory subCategory);

    void updateSubCategory(SubCategory subCategory);

    void deleteSubCategory(Long id);

}
