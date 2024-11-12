package com.biblio.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderProductResponse {
    private String title;
    private String imagePath;
    private int quantity;
    private double sellingPrice;
    private double totalPrice;
}
