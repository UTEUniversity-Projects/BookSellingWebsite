package com.biblio.entity;

import java.sql.Date;

public class Review {
    private String id;
    private int rate;
    private String content;
    private boolean readyToIntroduce;
    private Book book;
    private Customer createdBy;
    private Date createdAt;

    public Review() {
    }

    public Review(String id, int rate, String content, boolean readyToIntroduce, Book book, Customer createdBy, Date createdAt) {
        this.id = id;
        this.rate = rate;
        this.content = content;
        this.readyToIntroduce = readyToIntroduce;
        this.book = book;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isReadyToIntroduce() {
        return readyToIntroduce;
    }

    public void setReadyToIntroduce(boolean readyToIntroduce) {
        this.readyToIntroduce = readyToIntroduce;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Customer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
