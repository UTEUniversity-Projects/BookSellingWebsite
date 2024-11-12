package com.biblio.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthorResponse {
    private Long id;
    private String name;
    private String introduction;
    private String avatar;
}
