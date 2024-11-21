package com.biblio.dto.response;

import com.biblio.enumeration.EPromotionTemplateType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PromotionOrderResponse {
    private EPromotionTemplateType promotionType;
    private double discountAmount;
}