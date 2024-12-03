package com.biblio.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MediaFileRequest {
    private String fileName;
    private String storedCode;
}
