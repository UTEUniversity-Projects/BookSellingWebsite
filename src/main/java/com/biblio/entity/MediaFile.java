package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "media_file")
public class MediaFile implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "stored_code", nullable = false)
    private String storedCode;

    // endregion

    // region Relationships

    @ManyToOne
    @JoinColumn(name = "book_metadata_id")
    private BookMetadata bookMetadata;

    // endregion

    // region Constructors

    public MediaFile() {
    }

    public MediaFile(String id, String fileName, String storedCode, BookMetadata bookMetadata) {
        this.id = id;
        this.fileName = fileName;
        this.storedCode = storedCode;
        this.bookMetadata = bookMetadata;
    }

    //endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStoredCode() {
        return storedCode;
    }

    public void setStoredCode(String storedCode) {
        this.storedCode = storedCode;
    }

    public BookMetadata getBookMetadata() {
        return bookMetadata;
    }

    public void setBookMetadata(BookMetadata bookMetadata) {
        this.bookMetadata = bookMetadata;
    }


    // endregion
}
