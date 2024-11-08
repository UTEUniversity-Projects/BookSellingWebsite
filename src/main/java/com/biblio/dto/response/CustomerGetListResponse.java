package com.biblio.dto.response;

import com.biblio.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerGetListResponse {
    private Long id;
    private String avatar;
    private String dateOfBirth;  // Sử dụng LocalDate thay cho String
    private String email;
    private String fullName;
    private String gender;
    private String joinAt;  // Sử dụng LocalDateTime thay cho String
    private String phoneNumber;
    private String memberShip;
    private String username;
    private String password;
    private Set<AddressResponse> addresses = new HashSet<>();
}
