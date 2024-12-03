package com.biblio.dto.response;


import com.biblio.enumeration.EPromotionTargetType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class DiscountResponse {
    Long idApplied;
    Double percentDiscount;
    EPromotionTargetType promotionTargetType;
}
