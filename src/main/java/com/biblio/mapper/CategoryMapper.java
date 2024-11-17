package com.biblio.mapper;

import com.biblio.dto.request.CategoryRequest;
import com.biblio.dto.response.CategoryResponse;
import com.biblio.dto.response.CategorySidebarResponse;
import com.biblio.entity.Category;
import com.biblio.enumeration.EClassificationStatus;
import com.biblio.utils.EnumUtil;

public class CategoryMapper {
    public static Category toCategoryEntity(CategoryRequest categoryRequest) {
        return Category.builder()
                .id(Long.parseLong(categoryRequest.getId()))
                .name(categoryRequest.getName())
                .shortScript(categoryRequest.getShortScript())
                .fullScript(categoryRequest.getFullScript())
                .status(EnumUtil.fromDisplayName(EClassificationStatus.class, categoryRequest.getStatus()))
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId().toString())
                .name(category.getName())
                .shortScript(category.getShortScript())
                .fullScript(category.getFullScript())
                .status(category.getStatus().toString())
                .build();
    }
    public static CategorySidebarResponse toCategorySidebarResponse(Category category) {
        return CategorySidebarResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
