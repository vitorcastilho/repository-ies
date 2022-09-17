package com.ies.repository.entity;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(idUserType, userType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		return Objects.equals(idUserType, other.idUserType) && userType == other.userType;
	}
	
	

}
