package com.biblio.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SearchBookRequest {
    String title;
    Long categoryId;
    String sortBy;
}
