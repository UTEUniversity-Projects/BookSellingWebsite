package com.biblio.dto.response;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PromotionGetResponse {
    private Long id;
    private String code;
    private String title;
    private String description;
    private double percentDiscount;
    private double discountLimit;
    private double minValueApplied;
    private String status;
    private String effectiveDate;
    private String expirationDate;
    private String type;

    private Set<PromotionTargetResponse> promotionTargets = new HashSet<>();
}
