package com.ies.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.ies.repository.enums.RoleName;

@Entity
@Table(name = "user_type", schema = "repository")
public class UserType implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_type")
	private Long idUserType;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "user_type", unique = true)
	private RoleName userType;
	
	////////////////////////////////////////////////////////////////

	@Override
	public String getAuthority() {
		return this.userType.toString();
	}

	////////////////////////////////////////////////////////////////

	public UserType() {

	}

	public UserType(RoleName userType) {
		this.userType = userType;
	}

	public Long getIdUserType() {
		return idUserType;
	}

	public void setIdUserType(Long idUserType) {
		this.idUserType = idUserType;
	}

	public RoleName getUserType() {
		return userType;
	}

	public void setUserType(RoleName userType) {
		this.userType = userType;
	}

}
