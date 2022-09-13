package com.ies.repository.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ies.repository.entity.Summary;

public class FinalPaperDto {
	
	private Long idFinalPaper;
	
	@NotBlank
	@Size(max=150)
	private String title;
	
	@NotBlank
	@Size(max = 150)
	private String author;
	
	@NotBlank
	@Size(max = 4, min = 4)
	private int year;
	
	@NotBlank
	@Min(value = 1)
	@Max(value = 2)
	private int semester;
	
	@AssertTrue
	private Boolean isPublic;
	
	private Summary summary;
	
	@NotBlank
	private Long course;
	
	@NotBlank
	private Long user;
	
	private Long filePath;

	public Long getIdFinalPaper() {
		return idFinalPaper;
	}

	public void setIdFinalPaper(Long idFinalPaper) {
		this.idFinalPaper = idFinalPaper;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
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
