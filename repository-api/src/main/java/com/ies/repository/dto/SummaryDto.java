package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;

public class SummaryDto {

	private Long idSummary;
	
	@NotBlank
	private String summary;

	public Long getIdSummary() {
		return idSummary;
	}

	public void setIdSummary(Long idSummary) {
		this.idSummary = idSummary;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
