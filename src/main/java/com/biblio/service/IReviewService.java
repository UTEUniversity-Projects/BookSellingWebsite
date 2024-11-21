package com.biblio.service;

import com.biblio.dto.request.ReviewRequest;
import com.biblio.entity.Review;

public interface IReviewService {
    boolean updateReviewHidden(long reviewId, boolean isHidden);
    void createReview(ReviewRequest review);
}
