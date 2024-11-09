package com.biblio.dto.request;

import com.biblio.enumeration.EAccountStatus;
import com.biblio.enumeration.EMembership;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerActiveInActiveRequest {
    private Long id;
    private String avatar;
    private String dateOfBirth;
    private String email;
    private String fullName;
    private String gender;
    private String joinAt;
    private String phoneNumber;
    private EMembership memberShip;
    private EAccountStatus status;
    private String username;
    private String password;
}
