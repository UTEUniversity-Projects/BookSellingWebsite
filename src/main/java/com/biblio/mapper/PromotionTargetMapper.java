package com.biblio.mapper;

import com.biblio.dto.request.PromotionTargetInsertRequest;
import com.biblio.dto.response.PromotionTargetResponse;
import com.biblio.entity.PromotionTarget;

public class PromotionTargetMapper {
    public static PromotionTargetResponse toPromotionTargetResponse(PromotionTarget promotionTarget) {
        PromotionTargetResponse promotionTargetResponse = new PromotionTargetResponse();
//        promotionTargetResponse.setId(promotionTarget.getId());
//        promotionTargetResponse.setApplicableObjectId(promotionTarget.getApplicableObjectId());
//        promotionTargetResponse.setQuantity(promotionTarget.getQuantity());
//        promotionTargetResponse.setType(promotionTarget.getType().toString());

        return promotionTargetResponse;
    }

    public static PromotionTarget toPromotionTarget(PromotionTargetInsertRequest promotionTargetInsertRequest) {
        PromotionTarget promotionTarget = new PromotionTarget();
        promotionTarget.setApplicableObjectId(promotionTargetInsertRequest.getApplicableObjectId());
        promotionTarget.setType(promotionTargetInsertRequest.getType());
        return promotionTarget;
    }
}
