package com.biblio.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCardResponse {
    private Long id;
    private String title;
    private String sellingPrice;
    private String categoryName;
    private String condition;
    private String imageUrl;
    private double reviewRate;
    private long numberOfReviews;
}
