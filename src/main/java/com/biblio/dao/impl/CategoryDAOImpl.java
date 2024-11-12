package com.biblio.dao.impl;

import com.biblio.dao.ICategoryDAO;
import com.biblio.entity.Category;

import java.util.List;

public class CategoryDAOImpl extends GenericDAOImpl<Category> implements ICategoryDAO {
    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }
}
