package com.biblio.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CheckoutItemResponse {
    private Long bookTemplateId;
    private String title;
    private String imagePath;
    private int quantity;
    private double sellingPrice;
    private double totalPrice;
    private double discountPercent;

    public void calTotalPrice() {
        this.totalPrice = sellingPrice * quantity * (1 - discountPercent / 100);
    }
}
