package com.biblio.dao.impl;

import com.biblio.dao.ICategoryDAO;
import com.biblio.entity.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDAOImpl extends GenericDAOImpl<Category> implements ICategoryDAO {
    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }


    @Override
    public Category findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Category findBySubCategoryId(Long id) {
        String jpql = "SELECT c FROM Category c WHERE c.id = (SELECT s.category.id FROM SubCategory s WHERE s.id = :id)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return super.findSingleByJPQL(jpql, params);
    }

    @Override
    public void addCategory(Category category) {
        super.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        super.update(category);
    }

    @Override
    public void deleteCategory(Long id) {
        super.delete(id);
    }
}
