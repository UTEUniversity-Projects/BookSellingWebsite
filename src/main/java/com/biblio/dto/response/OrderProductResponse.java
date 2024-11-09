package com.biblio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderProductResponse {
    private String title;
    private int quantity;
    private double sellingPrice;
    private double totalPrice;
}
