package com.biblio.dto.response;

import com.biblio.enumeration.EOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderGetListResponse {
    private Long id;
    private String customerName;
    private double totalPrice;
    private EOrderStatus status;
    private String statusDisplay;
    private String statusStyle;
}
