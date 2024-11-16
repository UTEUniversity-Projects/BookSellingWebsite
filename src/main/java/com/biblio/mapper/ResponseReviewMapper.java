package com.biblio.mapper;

import com.biblio.dao.IReviewDAO;
import com.biblio.dao.impl.ReviewDAOImpl;
import com.biblio.dto.request.ResponseReviewRequest;
import com.biblio.entity.ResponseReview;
import com.biblio.entity.Review;
import com.biblio.service.IReviewService;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class ResponseReviewMapper {
    private static final ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
    // region DTOtoEntity

    public static ResponseReview toResponseReview(ResponseReviewRequest responseReviewRequest) {
        ResponseReview responseReview = new ResponseReview();
        Review review = reviewDAO.findById(responseReviewRequest.getReviewId());
        responseReview.setContent(responseReviewRequest.getContent());
        responseReview.setCreatedAt(LocalDateTime.now());
        responseReview.setCreatedBy("Staff");
        responseReview.setReview(review);
        return responseReview;
    }

    // endregion
}
