package com.biblio.dao;

import com.biblio.entity.Review;

public interface IReviewDAO extends IGenericDAO<Review> {
    Review findById(long id);
    Review update(Review review);
}
