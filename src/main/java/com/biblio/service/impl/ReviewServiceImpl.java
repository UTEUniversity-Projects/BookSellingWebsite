package com.biblio.service.impl;

import com.biblio.dao.IReviewDAO;

import com.biblio.entity.Review;
import com.biblio.service.IReviewService;

import javax.inject.Inject;

public class ReviewServiceImpl implements IReviewService {
    @Inject
    IReviewDAO reviewDAO;

    @Override
    public boolean updateReviewHidden(long reviewId, boolean isHidden) {
        Review review = reviewDAO.findById(reviewId);
        if (review != null) {
            review.setHidden(isHidden);
            reviewDAO.update(review);
            return true;
        }
        return false;
    }
}
