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
    private CustomerResponse customer;
    private ShippingResponse shipping;
    private String orderDate;
    private String note;
    private List<OrderProductResponse> products;
    private double totalPrice;
    private double finalPrice;
    private EOrderStatus status;
    private String statusDisplay;
    private String statusStyle;
    private String paymentMethod;
    private List<PromotionOrderResponse> promotions;
}
