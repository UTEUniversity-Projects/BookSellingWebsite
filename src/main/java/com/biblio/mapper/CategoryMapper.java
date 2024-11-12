package com.biblio.mapper;

import com.biblio.dto.response.CategoryGetListResponse;
import com.biblio.dto.response.CategoryResponse;
import com.biblio.entity.Category;

public class CategoryMapper {
    public static CategoryResponse toCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setShortScript(category.getShortScript());
        categoryResponse.setFullScript(category.getFullScript());
        categoryResponse.setStatus(category.getStatus().toString());
        return categoryResponse;
    }

    public static CategoryGetListResponse toCategoryGetListResponse(Category category) {
        CategoryGetListResponse categoryGetListResponse = new CategoryGetListResponse();
        categoryGetListResponse.setId(category.getId());
        categoryGetListResponse.setName(category.getName());

        return categoryGetListResponse;
    }
}
