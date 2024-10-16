package com.biblio.entity;

import java.sql.Date;

public class Review {
    //region Attributes
    private Long id;
    private int rate;
    private String content;
    private boolean readyToIntroduce;
    private Book book;
    private Customer createdBy;
    private Date createdAt;
    //endregion

    //region Constructors
    public Review() {
    }

    public Review(Long id, int rate, String content, boolean readyToIntroduce, Book book, Customer createdBy, Date createdAt) {
        this.id = id;
        this.rate = rate;
        this.content = content;
        this.readyToIntroduce = readyToIntroduce;
        this.book = book;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    //endregion
}
