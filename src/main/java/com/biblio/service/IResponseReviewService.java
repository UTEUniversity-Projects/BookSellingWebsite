package com.biblio.service;

import com.biblio.dto.request.ResponseReviewRequest;
import com.biblio.entity.ResponseReview;

public interface IResponseReviewService {
    public ResponseReview insertResponseReview(ResponseReviewRequest responseReviewRequest);
}
