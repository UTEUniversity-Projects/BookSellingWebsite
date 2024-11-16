package com.biblio.service;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.dto.response.PromotionTemplateGetResponse;

import java.util.List;

public interface IPromotionTemplateService {
    List<PromotionTemplateGetResponse> getAllPromotionTemplates();
    void insertPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest);
    Boolean isCodeExisted(String code);

}
