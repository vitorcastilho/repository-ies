package com.ies.repository.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CourseDto {
	
	private Long idCourse;

	@NotBlank
	@Size(max = 100)
	private String course;

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
}
