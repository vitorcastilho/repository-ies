package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class KindOfWorkDto {
	
	private Long idKindOfWork;

	@NotBlank
	@Size(max = 50)
	private String kindOfWork;

	public Long getIdKindOfWork() {
		return idKindOfWork;
	}

	public void setIdKindOfWork(Long idKindOfWork) {
		this.idKindOfWork = idKindOfWork;
	}

	public String getKindOfWork() {
		return kindOfWork;
	}

	public void setKindOfWork(String kindOfWork) {
		this.kindOfWork = kindOfWork;
	}
	
}
