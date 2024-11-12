package com.biblio.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubCategoryResponse {
    String id;
    String name;
    String shortScript;
    String fullScript;
    String status;
    String categoryId;
}