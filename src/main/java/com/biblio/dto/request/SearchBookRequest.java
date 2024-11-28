package com.biblio.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchBookRequest {
    String title;
    Long categoryId;
    String sortBy;
    int perPage;
    int pageNumber = 1;
    long minPrice;
    long maxPrice;
}
