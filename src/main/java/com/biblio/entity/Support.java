package com.biblio.entity;

import com.biblio.enumeration.ESupportStatus;

import java.io.Serializable;
import java.util.Date;

public class Support implements Serializable {
    //region Attributes
    private String id;
    private Customer customer;
    private String title;
    private String requestContent;
    private Staff staff;
    private String feedbackContent;
    private int rate;
    private ESupportStatus status;
    private Date requestAt;
    private Date responseAt;
    //endregion

    //region Contructors

    public Support(String id, Customer customer, String title, String requestContent, Staff staff, String feedbackContent, int rate, ESupportStatus status, Date requestAt, Date responseAt) {
        this.id = id;
        this.customer = customer;
        this.title = title;
        this.requestContent = requestContent;
        this.staff = staff;
        this.feedbackContent = feedbackContent;
        this.rate = rate;
        this.status = status;
        this.requestAt = requestAt;
        this.responseAt = responseAt;
    }

    //endregion

    //region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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

    public Date getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(Date requestAt) {
        this.requestAt = requestAt;
    }

    public Date getResponseAt() {
        return responseAt;
    }

    public void setResponseAt(Date responseAt) {
        this.responseAt = responseAt;
    }
//endregion
}
