package com.biblio.mapper;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTargetInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTarget;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PromotionMapper {
    public static PromotionGetResponse toPromotionGetResponse(Promotion promotion) {
        PromotionGetResponse promotionGetResponse = new PromotionGetResponse();
        promotionGetResponse.setId(promotion.getId());
        promotionGetResponse.setCode(promotion.getCode());
        promotionGetResponse.setTitle(promotion.getTitle());
        promotionGetResponse.setDescription(promotion.getDescription());
        promotionGetResponse.setPercentDiscount(promotion.getPercentDiscount());
        promotionGetResponse.setDiscountLimit(promotion.getDiscountLimit());
        promotionGetResponse.setMinValueApplied(promotionGetResponse.getMinValueApplied());
        promotionGetResponse.setStatus(promotion.getStatus().toString());
        promotionGetResponse.setEffectiveDate(promotion.getEffectiveDate().toString());
        promotionGetResponse.setExpirationDate(promotion.getExpirationDate().toString());
        promotionGetResponse.setType(promotion.getType().toString());

        for (PromotionTarget promotionTarget: promotion.getPromotionTargets()) {
            promotionGetResponse.getPromotionTargets().add(PromotionTargetMapper.toPromotionTargetResponse(promotionTarget));
        }
        return promotionGetResponse;
    }

    public static Promotion toPromotion(PromotionInsertRequest promotionInsertRequest) {
        Promotion promotion = new Promotion();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

        promotion.setCode(promotionInsertRequest.getCode());
        promotion.setTitle(promotionInsertRequest.getTitle());
        promotion.setDescription(promotionInsertRequest.getDescription());
        promotion.setPercentDiscount(promotionInsertRequest.getPercentDiscount());
        promotion.setDiscountLimit(promotionInsertRequest.getDiscountLimit());
        promotion.setMinValueToBeApplied(promotionInsertRequest.getMinValueApplied());
        promotion.setStatus(promotionInsertRequest.getStatus());
        promotion.setEffectiveDate(LocalDateTime.parse(promotionInsertRequest.getEffectiveDate(), formatter));
        promotion.setExpirationDate(LocalDateTime.parse(promotionInsertRequest.getExpirationDate(), formatter));
        promotion.setType(promotionInsertRequest.getType());
        promotion.setCreatedAt(LocalDateTime.now());

        for (PromotionTargetInsertRequest promotionTargetInsertRequest: promotionInsertRequest.getPromotionTargets()) {
            PromotionTarget promotionTarget = PromotionTargetMapper.toPromotionTarget(promotionTargetInsertRequest);
            promotionTarget.setPromotion(promotion);
            promotion.getPromotionTargets().add(promotionTarget);
        }
        return promotion;
    }
}
