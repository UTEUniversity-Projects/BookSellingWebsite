package com.biblio.dto.response;

import com.biblio.enumeration.EOrderStatus;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class OrderGetListResponse {
    private Long id;
    private String customerName;
    private String orderDate;
    private EOrderStatus status;
    private String statusDisplay;
    private String statusStyle;
    private double totalPrice;
}
