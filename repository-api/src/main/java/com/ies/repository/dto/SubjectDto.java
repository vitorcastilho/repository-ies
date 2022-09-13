package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SubjectDto {

	private Long idSubject;
	
	@NotBlank
	@Size(max = 5, min = 3)
	private String subjectCode;
	
	@NotBlank
	@Size(max = 100)
	private String subject;

	public Long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Long idSubject) {
		this.idSubject = idSubject;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
