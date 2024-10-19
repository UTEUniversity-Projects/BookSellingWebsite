package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Column(name = "content", nullable = false, columnDefinition = "nvarchar(255)")
    private String content;

    @Column(name = "ready_to_introduce", nullable = false, columnDefinition = "bit")
    private boolean readyToIntroduce;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    // endregion

    //region Constructors

    //region Constructors
    public Review() {
    }

    public Review(Long id, int rate, String content, boolean readyToIntroduce, Timestamp createdAt) {
        this.id = id;
        this.rate = rate;
        this.content = content;
        this.readyToIntroduce = readyToIntroduce;
        this.createdAt = createdAt;
    }

    // endregion

    // region Getters & Setters

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // endregion
}
