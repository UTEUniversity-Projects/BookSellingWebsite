package com.biblio.dao;

import com.biblio.entity.ResponseReview;
import com.biblio.entity.Review;

public interface IReviewDAO {
    Review findById(long id);
}
