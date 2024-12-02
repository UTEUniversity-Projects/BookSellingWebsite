package com.biblio.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoadRelatedBooksRequest {
    private Long bookTemplateId;
}
