package com.biblio.mapper;

import com.biblio.dto.request.SubCategoryRequest;
import com.biblio.dto.response.SubCategoryResponse;
import com.biblio.entity.SubCategory;
import com.biblio.enumeration.EClassificationStatus;
import com.biblio.utils.EnumUtil;

public class SubCategoryMapper {
    public static SubCategory toSubCategoryEntity(SubCategoryRequest subCategoryRequest) {
        return SubCategory.builder()
                .id(Long.parseLong(subCategoryRequest.getId()))
                .name(subCategoryRequest.getName())
                .shortScript(subCategoryRequest.getShortScript())
                .fullScript(subCategoryRequest.getFullScript())
                .status(EnumUtil.fromDisplayName(EClassificationStatus.class, subCategoryRequest.getStatus()))
                .build();
    }

    public static SubCategoryResponse toSubCategoryResponse(SubCategory subCategory) {
        return SubCategoryResponse.builder()
                .id(subCategory.getId().toString())
                .name(subCategory.getName())
                .shortScript(subCategory.getShortScript())
                .fullScript(subCategory.getFullScript())
                .status(EnumUtil.toDisplayName(subCategory.getStatus()))
                .build();
    }
}
