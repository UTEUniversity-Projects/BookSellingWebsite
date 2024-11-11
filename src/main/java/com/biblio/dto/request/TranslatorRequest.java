package com.biblio.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslatorRequest {
    String id;
    String name;
    String avatar;
    String introduction;
    String joinAt;
}
