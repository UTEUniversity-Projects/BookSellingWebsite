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
    private String code;
    private String title;
    private Long quantity;
    private String type;
}
