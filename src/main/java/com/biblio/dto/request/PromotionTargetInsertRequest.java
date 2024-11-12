package com.biblio.dto.request;

import com.biblio.enumeration.EPromotionTargetType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class PromotionTargetInsertRequest {
    private String applicableObjectId;
    private int quantity;
    private EPromotionTargetType type;
}
