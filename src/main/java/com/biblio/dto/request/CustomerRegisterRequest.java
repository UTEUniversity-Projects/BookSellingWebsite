package com.biblio.dto.request;

import lombok.*;

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
	private String province;
	private String district;
	private String village;
	private String detail;
	private String avatar;

}
