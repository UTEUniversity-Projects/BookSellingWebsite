package com.biblio.entity;

import com.biblio.enumeration.ESupportStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "support")
public class Support implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "request_content", nullable = false)
    private String requestContent;

    @Column(name = "feed_back_content", nullable = false)
    private String feedbackContent;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ESupportStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "responsed_at", nullable = false)
    private LocalDateTime responsedAt;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // endregion

    // region Constructors

    public Support() {
    }

    public Support(String id, String title, String requestContent, String feedbackContent, int rate, ESupportStatus status, LocalDateTime createdAt, LocalDateTime responsedAt, Staff staff, Customer customer) {
        this.id = id;
        this.title = title;
        this.requestContent = requestContent;
        this.feedbackContent = feedbackContent;
        this.rate = rate;
        this.status = status;
        this.createdAt = createdAt;
        this.responsedAt = responsedAt;
        this.staff = staff;
        this.customer = customer;
    }

    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ESupportStatus getStatus() {
        return status;
    }

    public void setStatus(ESupportStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getResponsedAt() {
        return responsedAt;
    }

    public void setResponsedAt(LocalDateTime responsedAt) {
        this.responsedAt = responsedAt;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    // endregion
}
