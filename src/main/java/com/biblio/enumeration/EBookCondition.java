package com.biblio.enumeration;

public enum EBookCondition {
    NEW("Mới"),
    USED("Đã qua sử dụng");

    private final String bookCondition;

    EBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    public String getBookCondition() {
        return bookCondition;
    }
}
