package com.biblio.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderOfCustomerResponse {
    private Long customerId;
    private String customerName;
    private Long orderId;
}
