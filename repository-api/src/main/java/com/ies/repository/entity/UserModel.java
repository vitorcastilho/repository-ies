package com.ies.repository.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user", schema = "repository")
public class UserModel  implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long idUser;

	@Column(nullable = false, name = "name")
	private String name;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "last_acess")
	private LocalDateTime lastAcess;

	@Column(nullable = false, name = "email", unique = true)
	private String email;

	@Column(nullable = false, name = "registration", unique = true)
	private Long registration;

	@Column(nullable = false, name = "password")
	private String password;
	
	@ManyToMany
	@JoinTable(name = "user_has_user_type",
					joinColumns = @JoinColumn(name = "id_user"),
					inverseJoinColumns = @JoinColumn(name = "id_user_type"))
	private List<UserType> userType;

	
	///////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.userType;
	}

	@Override
	public String getUsername() {
		return this.registration.toString();
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public UserModel() {

	}

	public UserModel(String name, LocalDateTime createdAt, LocalDateTime lastAcess, String email, Long registration,
			String password, List<UserType> userType) {
		this.name = name;
		this.createdAt = createdAt;
		this.lastAcess = lastAcess;
		this.email = email;
		this.registration = registration;
		this.password = password;
		this.userType = userType;
	}

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserType> getUserType() {
		return userType;
	}

	public void setUserType(List<UserType> userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, email, idUser, lastAcess, name, password, registration, userType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(idUser, other.idUser) && Objects.equals(lastAcess, other.lastAcess)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(registration, other.registration) && Objects.equals(userType, other.userType);
	}
	
	

}
