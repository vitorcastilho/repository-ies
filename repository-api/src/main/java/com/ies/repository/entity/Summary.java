package com.ies.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summary")
public class Summary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_summary")
	private Long idSummary;
	
	@Column(nullable=false, name = "summary")
	private String summary;

	
	public Summary() {
		super();
	}

	public Summary(String summary) {
		super();
		this.summary = summary;
	}

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
