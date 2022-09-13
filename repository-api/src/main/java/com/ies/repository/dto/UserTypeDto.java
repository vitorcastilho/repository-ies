package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserTypeDto {
	
	private Long idUserType;
	
	@NotBlank
	@Size(max=30)
	private String userType;

	public Long getIdUserType() {
		return idUserType;
	}

	public void setIdUserType(Long idUserType) {
		this.idUserType = idUserType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
