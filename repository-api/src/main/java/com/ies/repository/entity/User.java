package com.ies.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long idUser;
	
	@Column(nullable=false, name = "name")
	private String name;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "last_acess")
	private LocalDateTime lastAcess;
	
	@Column(nullable = false, name = "email")
	private String email;
	
	@Column(nullable = false, name = "registration")
	private Long registration;
	
	@Column(nullable = false, name = "password")
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_user_type")
	private UserType userType;

	public User() {

	}

	public User(String name, LocalDateTime createdAt, LocalDateTime lastAcess, String email, Long registration,
			String password, UserType userType) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
