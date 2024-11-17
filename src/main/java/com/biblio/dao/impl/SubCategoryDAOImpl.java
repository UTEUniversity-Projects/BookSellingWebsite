package com.biblio.dao.impl;

import com.biblio.dao.ISubCategoryDAO;
import com.biblio.entity.SubCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<SubCategory> findByJPQL(Long id) {
        String jpql = "SELECT s FROM SubCategory s WHERE s.category.id = :id"; // Dùng 'category.id' thay vì 'category_id'
        Map<String, Object> params = new HashMap<>();
        params.put("id", id); // Tham số cần khớp với ':id'
        return super.findByJPQL(jpql, params);
    }


    public static void main(String[] args) {
        List<SubCategory> subCategories = new ArrayList<SubCategory>();
        SubCategoryDAOImpl subCategoryDAO = new SubCategoryDAOImpl();
        subCategories = subCategoryDAO.findByJPQL(1L);
        System.out.println(subCategories.size());
    }
}
