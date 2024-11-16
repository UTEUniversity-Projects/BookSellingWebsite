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
    private String description;
    private double sellingPrice;

    private CategorySidebarResponse category;
    private BookMetadataResponse metadata;
    private double reviewRate;
}
