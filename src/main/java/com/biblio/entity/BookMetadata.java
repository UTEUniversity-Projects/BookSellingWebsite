package com.biblio.entity;

import com.biblio.enumeration.EBookStatus;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.List;

public class BookMetadata implements Serializable {
    private Long id;
    private DateTimeException createdAt;
    private DateTimeException openingDay;
    private double importPrice;
    private EBookStatus status;
    private List<MediaFile> illustration;
    private List<Tag> tags;

    public BookMetadata() {}

    public BookMetadata(Long id, DateTimeException createdAt, DateTimeException openingDay, double importPrice,
                        EBookStatus status, List<MediaFile> illustration, List<Tag> tags) {
        this.id = id;
        this.createdAt = createdAt;
        this.openingDay = openingDay;
        this.importPrice = importPrice;
        this.status = status;
        this.illustration = illustration;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTimeException getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTimeException createdAt) {
        this.createdAt = createdAt;
    }

    public DateTimeException getOpeningDay() {
        return openingDay;
    }

    public void setOpeningDay(DateTimeException openingDay) {
        this.openingDay = openingDay;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public EBookStatus getStatus() {
        return status;
    }

    public void setStatus(EBookStatus status) {
        this.status = status;
    }

    public List<MediaFile> getIllustration() {
        return illustration;
    }

    public void setIllustration(List<MediaFile> illustration) {
        this.illustration = illustration;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
