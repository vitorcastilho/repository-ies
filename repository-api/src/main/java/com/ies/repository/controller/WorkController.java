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

import com.ies.repository.dto.WorkDto;
import com.ies.repository.entity.Work;
import com.ies.repository.service.WorkService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/work")
public class WorkController {

	@Autowired
	private WorkService workService;
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	ResponseEntity<Object> saveNewWork(@RequestBody @Valid WorkDto workDto) {
		var work = new Work();
		BeanUtils.copyProperties(workDto, work);
		return ResponseEntity.status(HttpStatus.CREATED).body(workService.saveNewWork(work));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Work>> getAllWork() {
		return ResponseEntity.status(HttpStatus.OK).body(workService.listAllWork());
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getWorkById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(workService.findWorkById(id));
	}
	
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteWorkById(@PathVariable Long id) {
		workService.deleteByIdWork(id);
		return ResponseEntity.status(HttpStatus.OK).body("Trabalho exclu??do com sucesso.");
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateWork(@RequestBody @Valid WorkDto workDto) {
		var work = new Work();
		BeanUtils.copyProperties(workDto, work);
		return ResponseEntity.status(HttpStatus.OK).body(workService.updateWork(work));
	}
	
}
