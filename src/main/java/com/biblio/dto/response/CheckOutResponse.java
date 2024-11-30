package com.biblio.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CheckOutResponse {
    CustomerDetailResponse customer;
    List<CheckoutItemResponse> items;
    String address;
    double totalPrice;

    public void updateTotalPrice() {
        for (CheckoutItemResponse item : items) {
            this.totalPrice += item.getTotalPrice();
        }
    }
}
