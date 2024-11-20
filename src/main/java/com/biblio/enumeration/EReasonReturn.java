package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EReasonReturn {
    DAMAGED("Sách bị hỏng"),
    MISMATCH("Sách không đúng mô tả"),
    FAKE("Sách giả"),
    NO_NEEDED("Không còn cần thiết");

    private final String description;

    EReasonReturn(String value) {
        this.description = value;
    }
}