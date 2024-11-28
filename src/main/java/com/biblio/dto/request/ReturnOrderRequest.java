package com.biblio.dto.request;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReturnOrderRequest {
    private String reason;
    private String description;
    private Long orderId;
}
