package com.biblio.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerGetListResponse {
    private Long id;
    private String fullName;
    private String email;
    private String status;
}
