package com.ies.repository.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ies.repository.entity.UserType;

public class UserModelDto {

	private Long idUser;
	
	@NotBlank
	@Size(max = 100)
	private String name;
	
	private LocalDateTime lastAcess;
	
	@Email
	private String email;
	
//	@NotBlank
	private Long registration;
	
	@NotBlank
	@Size(max = 100)
	private String password;
	
//	@NotBlank
	private List<UserType> userType;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastAcess() {
		return lastAcess;
	}

	public void setLastAcess(LocalDateTime lastAcess) {
		this.lastAcess = lastAcess;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserType> getUserType() {
		return userType;
	}

	public void setUserType(List<UserType> userType) {
		this.userType = userType;
	}
	
}
