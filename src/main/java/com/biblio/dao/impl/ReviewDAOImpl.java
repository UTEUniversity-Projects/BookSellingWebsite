package com.biblio.dao.impl;

import com.biblio.dao.IReviewDAO;
import com.biblio.entity.Review;

public class ReviewDAOImpl extends GenericDAOImpl<Review> implements IReviewDAO {
    public ReviewDAOImpl() {
        super(Review.class);
    }

    @Override
    public Review findById(long id) {
        return super.findById(id);
    }

    public static void main(String[] args) {
        ReviewDAOImpl dao = new ReviewDAOImpl();
        Review review = dao.findById(1);
        System.out.println(review.getCustomer().getFullName());
    }
}
