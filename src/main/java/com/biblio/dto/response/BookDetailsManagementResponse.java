package com.biblio.dto.response;

import com.biblio.entity.Review;
import com.biblio.enumeration.EBookCondition;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookDetailsManagementResponse {
    private List<String> imagesUrl;
    private String title;
    private String description;
    private double totalRating;
    private String publicationDate;
    private String languages;
    private double sellingPrice;
    private int edition;
    private String condition;

    private List<AuthorResponse> authors = new ArrayList<>();
    private String publisher;

    private long quantity;
    private String size;
    private double weight;
    private int hardcover;
    private String format;

    private String codeISBN10;
    private String codeISBN13;
    private String ageRecommend;

    private List<ReviewResponse> reviews;
    private int reviewCount;
}
