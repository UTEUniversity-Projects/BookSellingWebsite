package com.biblio.dto.request;

import com.biblio.enumeration.EReasonReturn;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReturnOrderRequest {
    private EReasonReturn reason;
    private String description;
    private Long orderId;
    private List<ReturnBookRequest> returnBookItems; // Thêm trường này để chứa các item trả lại

}
