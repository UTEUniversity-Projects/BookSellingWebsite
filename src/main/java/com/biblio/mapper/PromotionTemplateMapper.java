package com.biblio.mapper;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTargetInsertRequest;
import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.dto.response.PromotionTemplateGetResponse;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTarget;
import com.biblio.entity.PromotionTemplate;
import com.biblio.enumeration.EPromotionStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PromotionTemplateMapper {
    public static PromotionTemplateGetResponse toPromotionTemplateGetResponse(List<Promotion> promotions) {
        Promotion promotion = promotions.get(0);
        PromotionTemplateGetResponse promotionTemplateGetResponse = new PromotionTemplateGetResponse();

        promotionTemplateGetResponse.setCode(promotion.getPromotionTemplate().getCode());
        promotionTemplateGetResponse.setTitle(promotion.getTitle());
        promotionTemplateGetResponse.setType(promotion.getPromotionTemplate().getType().toString());
        promotionTemplateGetResponse.setStatus(promotion.getPromotionTemplate().getStatus().toString());
        promotionTemplateGetResponse.setQuantity(Long.parseLong(String.valueOf((long) promotions.size())));

        promotionTemplateGetResponse.setDiscountLimit(promotion.getDiscountLimit());
        promotionTemplateGetResponse.setPercentDiscount(promotion.getPercentDiscount());

        return promotionTemplateGetResponse;
    }

    public static PromotionTemplate toPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest) {
        PromotionTemplate promotionTemplate = new PromotionTemplate();

        promotionTemplate.setCode(promotionTemplateInsertRequest.getCode());
        promotionTemplate.setInfinite(promotionTemplateInsertRequest.getIsInfinite());
        promotionTemplate.setStatus(promotionTemplateInsertRequest.getStatus());
        promotionTemplate.setType(promotionTemplateInsertRequest.getType());

        for (PromotionInsertRequest promotionInsertRequest: promotionTemplateInsertRequest.getPromotionInsertRequests()) {
            Promotion promotion = PromotionMapper.toPromotion(promotionInsertRequest);
            promotion.setPromotionTemplate(promotionTemplate);
            promotionTemplate.getPromotions().add(promotion);
        }
        promotionTemplate.setCreatedAt(LocalDateTime.now());
        return promotionTemplate;
    }
}
