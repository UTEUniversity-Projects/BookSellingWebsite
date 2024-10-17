package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "book_meta")
public class BookMetadata implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_ISBN10", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    @Column(name = "opening_date", nullable = false, columnDefinition = "datetime")
    private Timestamp openingDate;

    @Column(name = "import_price", nullable = false, columnDefinition = "double")
    private double importPrice;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    // endregion Attributes

    // region Constructors

    public BookMetadata() {
    }

    public BookMetadata(Long id, Timestamp createdAt, Timestamp openingDate, double importPrice, String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.openingDate = openingDate;
        this.importPrice = importPrice;
        this.status = status;
    }

    // endregion Constructors

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Timestamp openingDate) {
        this.openingDate = openingDate;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // endregion Getters & Setters
}
