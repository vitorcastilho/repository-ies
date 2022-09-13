package com.ies.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_type")
	private Long idUserType;
	
	@Column(nullable = false, name = "user_type")
	private String userType;
	
	public UserType() {
		
	}

	public UserType(String userType) {
		super();
		this.userType = userType;
	}

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
