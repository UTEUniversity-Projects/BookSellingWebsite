package com.biblio.dto.response;

import com.biblio.enumeration.EOrderStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderCustomerResponse {
    private Long id;
    private String note;
    private LocalDateTime orderDate;
    private String paymentType;
    private String status;
    private Double vat;
    private Long customerId;
    private Long shippingId;

}
