package com.biblio.mapper;

import com.biblio.dto.response.PromotionTargetResponse;
import com.biblio.entity.PromotionTarget;

public class PromotionTargetMapper {
    public static PromotionTargetResponse toPromotionTargetResponse(PromotionTarget promotionTarget) {
        PromotionTargetResponse promotionTargetResponse = new PromotionTargetResponse();
        promotionTargetResponse.setId(promotionTarget.getId());
        promotionTargetResponse.setApplicableObjectId(promotionTarget.getApplicableObjectId());
        promotionTargetResponse.setQuantity(promotionTarget.getQuantity());
        promotionTargetResponse.setType(promotionTarget.getType().toString());

        return promotionTargetResponse;
    }
}
