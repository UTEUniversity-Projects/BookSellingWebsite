package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "ready_to_introduce", nullable = false, columnDefinition = "bit")
    private boolean readyToIntroduce;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // endregion

    // region Constructors

    public Review() {
    }

    public Review(String id, int rate, String content, boolean readyToIntroduce, LocalDateTime createdAt) {
        this.id = id;
        this.rate = rate;
        this.content = content;
        this.readyToIntroduce = readyToIntroduce;
        this.createdAt = createdAt;
    }

    // endregion

    // region Getters & Setters

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // endregion
}
