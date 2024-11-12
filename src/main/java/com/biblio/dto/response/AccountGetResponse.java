package com.biblio.dto.response;

import com.biblio.enumeration.EAccountStatus;
import com.biblio.enumeration.EUserRole;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AccountGetResponse {
    private String username;
    private String password;
    private String status;
    private String role;
}
