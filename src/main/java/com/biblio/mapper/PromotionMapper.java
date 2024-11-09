package com.biblio.mapper;

import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTarget;

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
}
