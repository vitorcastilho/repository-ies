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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "work", schema = "repository")
public class Work {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_work")
	private Long idWork;
	
	@Column(nullable=false, name = "year_application")
	private int yearApplication;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "modified_in")
	private LocalDateTime modifiedIn;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_subject")
	private Subject subject;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_kind_of_work")
	private KindOfWork kindOfWork;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_user")
	private UserModel user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_file_path")
	private FilePath filePath;

	public Work() {
	
	}

	public Work(int yearApplication, LocalDateTime createdAt, LocalDateTime modifiedIn, Subject subject, KindOfWork kindOfWork,
			UserModel user, FilePath filePath) {
		this.yearApplication = yearApplication;
		this.createdAt = createdAt;
		this.modifiedIn = modifiedIn;
		this.subject = subject;
		this.kindOfWork = kindOfWork;
		this.user = user;
		this.filePath = filePath;
	}

	public Long getIdWork() {
		return idWork;
	}

	public void setIdWork(Long idWork) {
		this.idWork = idWork;
	}

	public int getYear() {
		return yearApplication;
	}

	public void setYear(int yearApplication) {
		this.yearApplication = yearApplication;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedIn() {
		return modifiedIn;
	}

	public void setModifiedIn(LocalDateTime modifiedIn) {
		this.modifiedIn = modifiedIn;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public KindOfWork getKindOfWork() {
		return kindOfWork;
	}

	public void setKindOfWork(KindOfWork kindOfWork) {
		this.kindOfWork = kindOfWork;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public FilePath getFilePath() {
		return filePath;
	}

	public void setFilePath(FilePath filePath) {
		this.filePath = filePath;
	}

}
