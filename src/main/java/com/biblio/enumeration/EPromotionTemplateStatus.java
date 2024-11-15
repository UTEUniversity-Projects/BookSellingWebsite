package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EPromotionTemplateStatus {
    COMING_SOON("Sắp mở bán"),
    EFFECTIVE("Còn hiệu lực"),
    USED_OUT("Đã hết lược"),
    EXPIRED("Hết lượt sử dụng");

    private final String value;

    EPromotionTemplateStatus(String value) {
        this.value = value;
    }

}
