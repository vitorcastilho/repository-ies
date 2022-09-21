package com.ies.repository.response;

import java.util.List;

import com.ies.repository.entity.UserType;

public class JwtResponse {

	

	private Long idUser;
	private Long registration;
	private String email;
	private String name;
	private String tokenType = "Bearer";
	private String accessToken;
	private List<UserType> roles;
	
	public JwtResponse(String token, Long id, Long registration, String email, String name, List<UserType> roles) {
		super();
		this.accessToken = token;
		this.idUser = id;
		this.registration = registration;
		this.email = email;
		this.name = name;
		this.roles = roles;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserType> getRoles() {
		return roles;
	}

	public void setRoles(List<UserType> roles) {
		this.roles = roles;
	}	
}
