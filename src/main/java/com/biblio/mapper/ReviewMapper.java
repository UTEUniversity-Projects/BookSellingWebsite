package com.biblio.mapper;

import com.biblio.dto.response.ReviewResponse;
import com.biblio.entity.ResponseReview;
import com.biblio.entity.Review;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ReviewMapper {
    public static ReviewResponse toReviewResponse(Review review) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return ReviewResponse.builder()
                .id(review.getId())
                .imageUrl(review.getCustomer().getAvatar())
                .customerName(review.getCustomer().getFullName())
                .rating(review.getRate())
                .createdAt(review.getCreatedAt() != null
                        ? review.getCreatedAt().format(formatter)
                        : "N/A")
                .content(review.getContent())
                .responseContent(Optional.ofNullable(review.getResponseReview())
                        .map(ResponseReview::getContent)
                        .orElse(""))
                .build();
    }
}
