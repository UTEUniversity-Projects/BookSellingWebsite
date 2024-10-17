package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "media_file")
public class MediaFile implements Serializable {

    //region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String fileName;

    @Column(name = "stored_code", nullable = false, columnDefinition = "nvarchar(255)")
    private String storedCode;

    //endregion

    //region Constructors
    public MediaFile() {
    }

    public MediaFile(Long id, String fileName, String storedCode) {
        this.id = id;
        this.fileName = fileName;
        this.storedCode = storedCode;
    }
    //endregion

    //region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    //endregion
}
