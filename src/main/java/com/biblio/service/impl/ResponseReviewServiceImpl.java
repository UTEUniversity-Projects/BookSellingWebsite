package com.biblio.service.impl;

import com.biblio.dao.IResponseReviewDAO;
import com.biblio.dto.request.ResponseReviewRequest;
import com.biblio.entity.ResponseReview;
import com.biblio.entity.Review;
import com.biblio.mapper.ResponseReviewMapper;
import com.biblio.service.IResponseReviewService;

import javax.inject.Inject;

public class ResponseReviewServiceImpl implements IResponseReviewService {
    @Inject
    private IResponseReviewDAO responseReviewDAO;
    @Override
    public ResponseReview insertResponseReview(ResponseReviewRequest responseReviewRequest) {
        ResponseReview responseReview = ResponseReviewMapper.toResponseReview(responseReviewRequest);
        return responseReviewDAO.save(responseReview);
    }

    @Override
    public boolean isExistResponseReview(long idReview) {
        return responseReviewDAO.isExist(idReview);
    }
}
