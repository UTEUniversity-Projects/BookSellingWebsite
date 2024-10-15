package com.biblio.entity;

import java.io.Serializable;

public class MediaFile implements Serializable {
    private String id;
    private String fileName;
    private String storedCode;

    public MediaFile() {
    }

    public MediaFile(String id, String fileName, String storedCode) {
        this.id = id;
        this.fileName = fileName;
        this.storedCode = storedCode;
    }

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
}
