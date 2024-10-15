package com.biblio.enumeration;

public enum ESupportStatus {
    SENT("Đã gửi"),
    NOT_RESPONDED("Chưa phản hồi"),
    RESPONDED("Đã phản hồi");

    private final String displayName;

    ESupportStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
