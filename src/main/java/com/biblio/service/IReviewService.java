package com.biblio.service;

import com.biblio.entity.Review;

public interface IReviewService {
    boolean updateReviewHidden(long reviewId, boolean isHidden);
}
