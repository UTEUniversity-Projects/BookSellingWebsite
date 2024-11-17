package com.biblio.dto.response;

import com.biblio.entity.ResponseReview;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewResponse {
    private String content;
    private String createdAt;
    private int rate;

    private CustomerResponse customer;
}
