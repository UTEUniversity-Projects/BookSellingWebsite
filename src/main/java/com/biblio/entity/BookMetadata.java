package com.biblio.entity;

import com.biblio.enumeration.EBookStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_metadata")
public class BookMetadata implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "opening_date", nullable = false)
    private LocalDateTime openingDate;

    @Column(name = "import_price", nullable = false)
    private double importPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EBookStatus status;

    // endregion Attributes

    // region Relationships

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "book_metadata_tag",
            joinColumns = @JoinColumn(name = "book_metadata_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
    )
    private Set<Tag> tags = new HashSet<Tag>();

    @OneToOne(mappedBy = "metadata")
    private Book book;

    @OneToMany(mappedBy = "bookMetadata", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MediaFile> mediaFiles;

    // endregion

    // region Constructors

    public BookMetadata() {
    }

    public BookMetadata(String id, LocalDateTime createdAt, LocalDateTime openingDate, double importPrice, EBookStatus status) {
        this.id = id;
        this.createdAt = createdAt;
        this.openingDate = openingDate;
        this.importPrice = importPrice;
        this.status = status;
    }

    // endregion Constructors

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<MediaFile> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(Set<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    // endregion Getters & Setters
}
