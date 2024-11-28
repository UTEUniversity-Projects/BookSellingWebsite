package com.biblio.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class OrderProductResponse {
    private Long bookId;
    private String title;
    private String imagePath;
    private int quantity;
    private double sellingPrice;
    private double totalPrice;
}
