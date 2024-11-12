package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EGender {
    MALE("Nam"),
    FEMALE("Nữ");

    private final String displayName;

    EGender(String displayName) {
        this.displayName = displayName;
    }

}
