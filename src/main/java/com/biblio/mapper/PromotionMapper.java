package com.biblio.mapper;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTargetInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTarget;
import com.biblio.enumeration.EPromotionStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PromotionMapper {
    public static PromotionGetResponse toPromotionGetResponse(List<Promotion> promotions) {
        Promotion promotion = promotions.get(0);
        PromotionGetResponse promotionGetResponse = new PromotionGetResponse();
        promotionGetResponse.setCode(promotion.getPromotionTemplate().getCode());
        promotionGetResponse.setTitle(promotion.getTitle());
        promotionGetResponse.setType(promotion.getPromotionTemplate().getType().toString());

        Long count = (Long) promotions.stream()
                .filter(pro -> pro.getStatus() == EPromotionStatus.NOT_USE)
                .count();
        promotionGetResponse.setQuantity(count);
        return promotionGetResponse;
    }

    public static Promotion toPromotion(PromotionInsertRequest promotionInsertRequest) {
        Promotion promotion = new Promotion();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

        promotion.setTitle(promotionInsertRequest.getTitle());
        promotion.setDescription(promotionInsertRequest.getDescription());

        promotion.setPercentDiscount(promotionInsertRequest.getPercentDiscount());
        promotion.setDiscountLimit(promotionInsertRequest.getDiscountLimit());
        promotion.setMinValueToBeApplied(promotionInsertRequest.getMinValueApplied());

        promotion.setStatus(promotionInsertRequest.getStatus());

        promotion.setEffectiveDate(LocalDateTime.parse(promotionInsertRequest.getEffectiveDate(), formatter));
        promotion.setExpirationDate(LocalDateTime.parse(promotionInsertRequest.getExpirationDate(), formatter));

        for (PromotionTargetInsertRequest promotionTargetInsertRequest: promotionInsertRequest.getPromotionTargets()) {
            PromotionTarget promotionTarget = PromotionTargetMapper.toPromotionTarget(promotionTargetInsertRequest);
            promotionTarget.setPromotion(promotion);
            promotion.getPromotionTargets().add(promotionTarget);
        }
        return promotion;
    }
}
