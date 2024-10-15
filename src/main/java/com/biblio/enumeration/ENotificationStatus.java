package com.biblio.enumeration;

public enum ENotificationStatus {
    NOT_SEEN("Chưa xem"),
    VIEWED("Đã xem");

    private final String displayName;

    ENotificationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
