package com.biblio.service;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;

import java.util.List;

public interface IPromotionService {
    List<PromotionGetResponse> getAllPromotions();
    PromotionGetResponse getPromotionById(Long id);
    void insertPromotion(PromotionInsertRequest promotionInsertRequest);
    Boolean isCodeExisted(String code);
}
