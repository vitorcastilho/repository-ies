package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TagDto {

	private Long idTag;
	
	@NotBlank
	@Size(max = 50)
	private String tag;

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
