package com.ies.repository.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "final_paper", schema = "repository")
public class FinalPaper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_final_paper")
	private Long idFinalPaper;
	
	@Column(nullable=false, name = "title")
	private String title;
	
	@Column(nullable=false, name = "author")
	private String author;
	
	@Column(nullable=false, name = "year")
	private int year;
	
	@Column(nullable=false, name = "semester")
	private int semester;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "modified_in")
	private LocalDateTime modifiedIn;
	
	@Column(nullable=false, name = "is_public")
	private Boolean isPublic;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_summary")
	private Summary summary;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_course")
	private Course course;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_user")
	private UserModel user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_file_path")
	private FilePath filePath;
	
	@ManyToMany
	@JoinTable(name = "final_paper_has_tag", joinColumns = {@JoinColumn(name = "id_final_paper")}, inverseJoinColumns = {@JoinColumn(name = "id_tag")})
	private List<Tag> tag;

	public FinalPaper() {
		
	}

	public FinalPaper(String title, String author, int year, int semester, LocalDateTime createdAt,
			LocalDateTime modifiedIn, Boolean isPublic, Summary summary, Course course, UserModel user, FilePath filePath, List<Tag> tag) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.semester = semester;
		this.createdAt = createdAt;
		this.modifiedIn = modifiedIn;
		this.isPublic = isPublic;
		this.summary = summary;
		this.course = course;
		this.user = user;
		this.filePath = filePath;
		this.tag = tag;
	}

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedIn() {
		return modifiedIn;
	}

	public void setModifiedIn(LocalDateTime modifiedIn) {
		this.modifiedIn = modifiedIn;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public FilePath getFilePath() {
		return filePath;
	}

	public void setFilePath(FilePath filePath) {
		this.filePath = filePath;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
	
}
