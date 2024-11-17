package com.biblio.service.impl;

import com.biblio.dao.IReviewDAO;
import com.biblio.dao.impl.GenericDAOImpl;
import com.biblio.dto.response.ReviewResponse;
import com.biblio.entity.Review;
import com.biblio.service.IReviewService;

import javax.inject.Inject;
import java.util.List;

public class ReviewServiceImpl extends GenericDAOImpl<Review> implements IReviewService {
    @Inject
    private IReviewDAO reviewDAO;

    public ReviewServiceImpl() {
        super(Review.class);
    }

//    @Override
//    public List<ReviewResponse> getVisibleReviewResponse() {
//        List<Review> reviews = reviewDAO.findAll();
//    }
}
