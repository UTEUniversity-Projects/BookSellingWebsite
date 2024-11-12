package com.biblio.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryResponse {
    private Long id;
    private String name;
    private String shortScript;
    private String fullScript;
    private String status;
}
