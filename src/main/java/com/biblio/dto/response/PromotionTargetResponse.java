package com.biblio.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PromotionTargetResponse {
    private Long id;
    private String applicableObjectId;
    private int quantity;
    private String type;
}
