package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EBookStatus {
    COMING_SOON("Sắp ra mắt"),
    ON_SALE("Đang mở bán"),
    OUT_OF_STOCK("Hết hàng"),
    STOP_SELLING("Ngừng kinh doanh");

    private final String bookStatus;

    EBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

}
