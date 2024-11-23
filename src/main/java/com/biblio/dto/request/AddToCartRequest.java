package com.biblio.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddToCartRequest {
    private Long bookTemplateId;
    private Long cartId;
    private Long quantity;
}