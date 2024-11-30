package com.biblio.dto.request;


import com.biblio.entity.Account;
import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EReasonReturn;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerInformationRequest {
    private Long id;
    private String avatar;
    private LocalDate dateOfBirth;
    private String email;
    private String fullName;
    private EGender gender;
    private String joinAt;
    private String phoneNumber;
    private String memberShip;
    private Long accountId;
}
