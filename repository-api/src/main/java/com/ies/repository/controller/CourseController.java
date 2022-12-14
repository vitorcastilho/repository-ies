package com.ies.repository.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.dto.CourseDto;
import com.ies.repository.entity.Course;
import com.ies.repository.service.CourseService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	public ResponseEntity<Object> saveNewCourse(@RequestBody @Valid CourseDto courseDto) {
		var course = new Course();
		BeanUtils.copyProperties(courseDto, course);
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveNewCourse(course));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Course>> getAllCourse() {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.listAllCourse());
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCourseById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.findCourseById(id));
	}
	
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteWorkById(@PathVariable Long id) {
		courseService.deleteByIdCourse(id);
		return ResponseEntity.status(HttpStatus.OK).body("Curso exclu??do com sucesso.");
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateCourse(@RequestBody @Valid CourseDto courseDto){
		var course = new Course();
		BeanUtils.copyProperties(courseDto, course);
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.updateCourse(course));
	}
}