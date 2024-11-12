package com.biblio.dao;

import com.biblio.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();
}
