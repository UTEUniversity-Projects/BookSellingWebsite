package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "support")
public class Support implements Serializable {

    //region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "nvarchar(255)")
    private String title;

    @Column(name = "request_content", nullable = false, columnDefinition = "nvarchar(255)")
    private String requestContent;

    @Column(name = "feed_back_content", nullable = false, columnDefinition = "nvarchar(255)")
    private String feedbackContent;

    @Column(name = "rate", nullable = false, columnDefinition = "int")
    private int rate;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    // endregion

    // region Constructors

    public Support() {
    }

    public Support(Long id, String title, String requestContent, String feedbackContent, int rate, String status, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.requestContent = requestContent;
        this.feedbackContent = feedbackContent;
        this.rate = rate;
        this.status = status;
        this.createdAt = createdAt;
    }

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // endregion
}
