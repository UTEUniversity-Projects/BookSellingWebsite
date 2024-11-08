package com.biblio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerGetListResponse {
    private Long id;
    private String avatar;
    private String dateOfBirth;
    private String email;
    private String fullName;
    private String gender;
    private String joinAt;
    private String phoneNumber;
    private String memberShip;
    private String status;
    private String username;
    private String password;
    private Set<AddressResponse> addresses = new HashSet<>();
}
