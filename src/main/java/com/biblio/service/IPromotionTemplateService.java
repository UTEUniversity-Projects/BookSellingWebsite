package com.biblio.service;

import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.request.PromotionTemplateUpdateRequest;
import com.biblio.dto.response.*;
import com.biblio.entity.OrderItem;

import java.util.List;

public interface IPromotionTemplateService {
    PromotionTemplateGetDetailsResponse getPromotionTemplateById(Long id);

    PromotionTemplateResponse getPromotionTemplateDetailsById(Long id);

    PromotionTemplateGetDetailsResponse getPromotionTemplateByCode(String code);

    List<PromotionTemplateGetResponse> getAllPromotionTemplates();

    void updatePromotionTemplate(PromotionTemplateUpdateRequest promotionTemplateUpdateRequest);

    PromotionTemplateResponse insertPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest);

    Boolean isCodeExisted(String code);

    Double percentDiscountOfBook(Long bookTemplateId);

    ApplyCodePromotionResponse applyCodePromotion(String code);

}
