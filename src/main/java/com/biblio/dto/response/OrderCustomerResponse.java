package com.biblio.dto.response;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderCustomerResponse {
    private long id;
    private String note;
    private String orderDate;
    private String paymentType;
    private String status;
    private Double vat;
    private Long customerId;
    private Long shippingId;
    private Double totalPrice;
    private Set<BookResponse> book = new HashSet<>();

}
