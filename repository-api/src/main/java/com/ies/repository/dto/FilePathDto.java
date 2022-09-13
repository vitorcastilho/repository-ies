package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FilePathDto {
	
	private Long idFilePath; 

	@NotBlank
	@Size(max = 200)
	private String filePath;

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
