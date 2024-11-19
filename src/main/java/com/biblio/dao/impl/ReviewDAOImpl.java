package com.biblio.dao.impl;

import com.biblio.dao.IReviewDAO;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewDAOImpl extends GenericDAOImpl<Review> implements IReviewDAO {
    public ReviewDAOImpl() {
        super(Review.class);
    }

    @Override
    public Review findById(long id) {
        return super.findById(id);
    }

    @Override
    public List<Review> findByBookTemplate(BookTemplate bookTemplate) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT r ")
                .append("FROM Review r ")
                .append("LEFT JOIN FETCH r.responseReview rr ")
                .append("JOIN FETCH r.customer c ")
                .append("WHERE r.bookTemplate = :bookTemplate");

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplate", bookTemplate);
        return super.findByJPQL(jpql.toString(), params);
    }

    @Override
    public Review update(Review review) {
        return super.update(review);
    }

    public static void main(String[] args) {
        ReviewDAOImpl dao = new ReviewDAOImpl();
        Review review = dao.findById(1);
        review.setHidden(true);
        review = dao.update(review);
        System.out.println(review.isHidden());
    }
}
