package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EBookCondition {
    NEW("Mới"),
    USED("Đã qua sử dụng");

    private final String bookCondition;

    EBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

}
