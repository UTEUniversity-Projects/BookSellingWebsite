package com.biblio.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ShippingResponse {
    private String address;
    private String shippingUnit;
    private double shippingFee;
}
