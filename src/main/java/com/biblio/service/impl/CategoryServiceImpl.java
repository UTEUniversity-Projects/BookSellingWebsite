package com.biblio.service.impl;

import com.biblio.dao.ICategoryDAO;
import com.biblio.dto.response.CategoryGetListResponse;
import com.biblio.entity.Category;
import com.biblio.service.ICategoryService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.biblio.mapper.CategoryMapper.toCategoryGetListResponse;

public class CategoryServiceImpl implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryGetListResponse> findAll() {
        List<CategoryGetListResponse> list = new ArrayList<>();
        for (Category category : categoryDAO.findAll()) {
            list.add(toCategoryGetListResponse(category));
        }
        return list;
    }
}
