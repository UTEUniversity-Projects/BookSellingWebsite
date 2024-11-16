package com.biblio.dao.impl;

import com.biblio.dao.IPromotionDAO;
import com.biblio.dao.IResponseReviewDAO;
import com.biblio.entity.Promotion;
import com.biblio.entity.ResponseReview;

public class ResponseReviewDAOImpl extends GenericDAOImpl<ResponseReview> implements IResponseReviewDAO {
    public ResponseReviewDAOImpl()  {
        super(ResponseReview.class);
    }

    public ResponseReview save(ResponseReview responseReview) {
        return super.save(responseReview);
    }
}
