package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EBookMetadataStatus {
    SOLD("Đã bán"),
    IN_STOCK("Chưa bán");

    private final String value;

    EBookMetadataStatus(String value) {
        this.value = value;
    }
}