package com.ies.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kind_of_work", schema = "repository")
public class KindOfWork {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_kind_of_work")
	private Long idKindOfWork;
	
	@Column(nullable=false, name = "kind_of_work")
	private String kindOfWork;

	public KindOfWork() {

	}

	public KindOfWork(String kindOfWork) {
		super();
		this.kindOfWork = kindOfWork;
	}

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
