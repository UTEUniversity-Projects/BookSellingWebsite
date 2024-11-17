package com.biblio.dto.response;

import com.biblio.enumeration.EOrderStatus;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class OrderDetailsManagementResponse {
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String address;
    private String shippingUnit;
    private double shippingFee;
    private String orderDate;
    private String note;
    private List<OrderProductResponse> products;
    private double totalPrice;
    private EOrderStatus status;
    private String statusDisplay;
    private String statusStyle;
}