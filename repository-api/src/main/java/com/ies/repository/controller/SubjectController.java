package com.ies.repository.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.dto.SubjectDto;
import com.ies.repository.entity.Subject;
import com.ies.repository.service.SubjectService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping
	public ResponseEntity<Object> saveNewSubject(@RequestBody @Valid SubjectDto subjectDto) {
		var subject = new Subject();
		BeanUtils.copyProperties(subjectDto, subject);
		return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.saveNewSubject(subject));
	}
	
	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubject() {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.listAllSubject());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdSubject(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.findByIdSubject(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteByIdSubject(@PathVariable Long id) {
		subjectService.deleteByIdSubject(id);
		return ResponseEntity.status(HttpStatus.OK).body("Matéria excluída com sucesso.");
	}
	
	@PutMapping
	public ResponseEntity<Object> updateSubject(@RequestBody @Valid SubjectDto subjectDto) {
		var subject = new Subject();
		BeanUtils.copyProperties(subjectDto, subject);
		return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.saveNewSubject(subject));
	}
	
}
