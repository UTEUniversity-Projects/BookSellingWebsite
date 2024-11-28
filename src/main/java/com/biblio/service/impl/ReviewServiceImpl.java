package com.biblio.service.impl;

import com.biblio.dao.*;
import com.biblio.dao.impl.BookTemplateDAOImpl;
import com.biblio.dao.impl.CustomerDAOImpl;
import com.biblio.dao.impl.NotificationDAOImpl;
import com.biblio.dao.impl.ReviewDAOImpl;
import com.biblio.dto.request.ReviewRequest;
import com.biblio.dto.response.ReviewResponse;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.Customer;
import com.biblio.entity.ResponseReview;
import com.biblio.entity.Review;
import com.biblio.mapper.ResponseReviewMapper;
import com.biblio.mapper.ReviewMapper;
import com.biblio.service.IReviewService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


public class ReviewServiceImpl implements IReviewService {

    @PersistenceContext
    private EntityManager entityManager; // EntityManager sẽ được tiêm tự động bởi Spring hoặc Java EE

    private IReviewDAO reviewDAO;
    private ICustomerDAO customerDAO;

    private IBookTemplateDAO bookTemplateDAO;
    private INotificationDAO notificationDAO;

    // Constructor tiêm phụ thuộc
    public ReviewServiceImpl(IReviewDAO reviewDAO,
                             INotificationDAO notificationDAO) {
        this.reviewDAO = reviewDAO;
        this.notificationDAO = notificationDAO;
    }
    public ReviewServiceImpl(){
        this.reviewDAO = new ReviewDAOImpl();
        this.notificationDAO = new NotificationDAOImpl();
        this.customerDAO = new CustomerDAOImpl();
        this.bookTemplateDAO = new BookTemplateDAOImpl();
    }
    @Override
    public ReviewResponse updateReviewHidden(long reviewId, boolean isHidden) {
        Review review = reviewDAO.findById(reviewId);
        if (review != null) {
            review.setHidden(isHidden);
            review = reviewDAO.update(review);
            ReviewResponse reviewResponse = ReviewMapper.toReviewResponse(review);
            return reviewResponse;
        }
        return null;
    }

    @Transactional
    @Override
    public void createReview(ReviewRequest reviewRequest) {
        if (reviewRequest == null || reviewRequest.getContent() == null) {
            throw new IllegalArgumentException("Review không hợp lệ: Tiêu đề hoặc nội dung không được để trống.");
        }

        Customer customer = customerDAO.findById(reviewRequest.getCustomerId());
        if (customer == null) {
            throw new IllegalArgumentException("Customer không tồn tại.");
        }

        // Tìm BookTemplate
        BookTemplate bookTemplate = bookTemplateDAO.findById(reviewRequest.getBookTemplateId());
        if (bookTemplate == null) {
            throw new IllegalArgumentException("BookTemplate không tồn tại.");
        }

        // Tạo Review từ request và lưu vào cơ sở dữ liệu
        Review review = ReviewMapper.toEntity(reviewRequest, customer, bookTemplate);
            reviewDAO.save(review);
    }
}
