package com.biblio.dto.request;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReviewRequest {
    private String content;
    private int rate;
    private Long customerId;
    private Long bookTemplateId;
    private boolean ready_to_introduce;
}
