package com.biblio.dto.request;

import com.biblio.enumeration.EAccountStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerActiveInActiveRequest {
    private Long id;
    private EAccountStatus status;
}
