package com.biblio.dto.response;

import com.biblio.enumeration.EOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailsResponse {
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String address;
    private String orderDate;
    private String note;
    private List<OrderProductResponse> products;
    private double totalPrice;
    private EOrderStatus status;
    private String statusDisplay;
    private String statusStyle;
}
