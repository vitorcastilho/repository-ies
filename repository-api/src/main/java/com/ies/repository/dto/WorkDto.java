package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WorkDto {
	
	private Long idWork;

	@NotBlank
	@Size(max = 4)
	private int yearApplication;
	
	@NotBlank
	private Long subject;
	
	@NotBlank
	private Long kindOfWork;
	
	@NotBlank
	private Long user;
	
	@NotBlank
	private Long filePath;

	public Long getIdWork() {
		return idWork;
	}

	public void setIdWork(Long idWork) {
		this.idWork = idWork;
	}

	public int getYearApplication() {
		return yearApplication;
	}

	public void setYearApplication(int yearApplication) {
		this.yearApplication = yearApplication;
	}

	public Long getSubject() {
		return subject;
	}

	public void setSubject(Long subject) {
		this.subject = subject;
	}

	public Long getKindOfWork() {
		return kindOfWork;
	}

	public void setKindOfWork(Long kindOfWork) {
		this.kindOfWork = kindOfWork;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getFilePath() {
		return filePath;
	}

	public void setFilePath(Long filePath) {
		this.filePath = filePath;
	}
	
}
