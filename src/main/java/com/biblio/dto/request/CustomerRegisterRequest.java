package com.biblio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
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
