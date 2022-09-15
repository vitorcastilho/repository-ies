package com.ies.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file_path", schema = "repository")
public class FilePath {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_file_path")
	private Long idFilePath;
	
	@Column(nullable=false, name = "file_path")
	private String filePath;

	public FilePath() {

	}

	public FilePath(String filePath) {
		super();
		this.filePath = filePath;
	}

	public Long getIdFilePath() {
		return idFilePath;
	}

	public void setIdFilePath(Long idFilePath) {
		this.idFilePath = idFilePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
