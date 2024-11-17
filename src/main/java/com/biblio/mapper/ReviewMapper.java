package com.biblio.mapper;

import com.biblio.dto.response.ReviewResponse;
import com.biblio.entity.Review;

import static com.biblio.utils.DateTimeUtil.formatDateTime;


public class ReviewMapper {
    public static ReviewResponse toReviewResponse(Review review) {
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setContent(review.getContent());
        reviewResponse.setCreatedAt(formatDateTime(review.getCreatedAt(), "dd-MM-yyy"));
        reviewResponse.setRate(review.getRate());
        reviewResponse.setCustomer(CustomerMapper.customerResponse(review.getCustomer()));

        return reviewResponse;
    }
}
