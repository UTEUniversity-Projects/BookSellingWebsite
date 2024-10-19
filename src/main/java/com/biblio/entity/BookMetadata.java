package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "book_metadata")
public class BookMetadata implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    @Column(name = "opening_date", nullable = false, columnDefinition = "datetime")
    private Timestamp openingDate;

    @Column(name = "import_price", nullable = false, columnDefinition = "double")
    private double importPrice;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    // endregion Attributes

    // region Relationships

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_metadata_tag",
            joinColumns = @JoinColumn(name = "book_metadata_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false)
    )
    private Set<Tag> tags;

    @OneToOne(mappedBy = "metadata")
    private Book book;

    @OneToMany(mappedBy = "bookMetadata")
    private Set<MediaFile> mediaFiles;

    // endregion

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    // endregion Getters & Setters
}
