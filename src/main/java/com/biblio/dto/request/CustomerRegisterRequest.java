package com.biblio.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerRegisterRequest {

	private String fullName;
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private String gender;
	private String username;
	private String password;
	private String city;
	private String district;
	private String ward;
	private String hamlet;
	private String avatar;

}
