package com.biblio.dto.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookResponse {
    private Long id;
    private String title;
    private String description;
    private double sellingPrice;
    private String publicationDate;
    private int edition;
    private String codeISBN10;
    private String codeISBN13;
    private String format;
    private int handcover;
    private double length;
    private double width;
    private double height;
    private double weight;
    private String condition;
    private String recommendedAge;
    private String languages;

    private CategoryResponse category;
    private PublisherResponse publisher;
    private BookMetadataResponse metadata;
    private List<AuthorResponse> authors = new ArrayList<>();
}
