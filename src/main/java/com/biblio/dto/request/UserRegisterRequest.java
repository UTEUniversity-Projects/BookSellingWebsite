package com.biblio.dto.request;

public class UserRegisterRequest {

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

	public UserRegisterRequest() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getHamlet() {
		return hamlet;
	}

	public void setHamlet(String hamlet) {
		this.hamlet = hamlet;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "UserRegisterRequest{" +
				"fullName='" + fullName + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", gender='" + gender + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", city='" + city + '\'' +
				", district='" + district + '\'' +
				", ward='" + ward + '\'' +
				", hamlet='" + hamlet + '\'' +
				", avatar='" + avatar + '\'' +
				'}';
	}
}
