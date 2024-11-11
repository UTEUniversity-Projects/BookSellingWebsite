package com.biblio.dao.impl;

import com.biblio.dao.ISubCategoryDAO;
import com.biblio.entity.SubCategory;

import java.util.List;

public class SubCategoryDAOImpl extends GenericDAOImpl<SubCategory> implements ISubCategoryDAO {
    public SubCategoryDAOImpl() {
        super(SubCategory.class);
    }

    @Override
    public List<SubCategory> findAll() {
        return super.findAll();
    }

    @Override
    public SubCategory findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void addSubCategory(SubCategory subCategory) {
        super.save(subCategory);
    }

    @Override
    public void updateSubCategory(SubCategory subCategory) {
        super.update(subCategory);
    }

    @Override
    public void deleteSubCategory(Long id) {
        super.delete(id);
    }
}
