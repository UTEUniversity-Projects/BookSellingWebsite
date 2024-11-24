package com.biblio.service;

import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.request.PromotionTemplateUpdateRequest;
import com.biblio.dto.response.PromotionTemplateGetDetailsResponse;
import com.biblio.dto.response.PromotionTemplateGetResponse;
import com.biblio.dto.response.PromotionTemplateResponse;

import java.util.List;

public interface IPromotionTemplateService {
    PromotionTemplateGetDetailsResponse getPromotionTemplateById(Long id);

    PromotionTemplateResponse getPromotionTemplateDetailsById(Long id);

    PromotionTemplateGetDetailsResponse getPromotionTemplateByCode(String code);

    List<PromotionTemplateGetResponse> getAllPromotionTemplates();

    void updatePromotionTemplate(PromotionTemplateUpdateRequest promotionTemplateUpdateRequest);

    void insertPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest);

    Boolean isCodeExisted(String code);

    Double percentDiscountOfBook(Long bookTemplateId);

}
