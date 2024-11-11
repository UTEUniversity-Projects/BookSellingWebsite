package com.biblio.dto.request;

import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PromotionInsertRequest {
    private String code;
    private String title;
    private String description;
    private double percentDiscount;
    private double discountLimit;
    private double minValueApplied;
    private EPromotionStatus status;
    private String effectiveDate;
    private String expirationDate;
    private EPromotionType type;
    private Set<PromotionTargetInsertRequest> promotionTargets = new HashSet<>();
}
