package com.biblio.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "response_review")
public class ResponseReview {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_id", nullable = false)
    private String reviewId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // endregion

    // region Constructors

    public ResponseReview() {
    }

    public ResponseReview(Long id, String reviewId, String content, String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.reviewId = reviewId;
        this.content = content;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // endregion
}
