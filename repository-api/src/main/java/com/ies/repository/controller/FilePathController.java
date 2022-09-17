package com.ies.repository.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.ies.repository.dto.FilePathDto;
import com.ies.repository.entity.FilePath;
import com.ies.repository.service.FilePathService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/file-path")
public class FilePathController {
	
	private FilePathService filePathService;

	public FilePathController(FilePathService filePathService) {
		this.filePathService = filePathService;
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@PostMapping
	public ResponseEntity<Object> saveNewFilePath(@RequestBody @Valid FilePathDto filePathDto) {
		var filePath = new FilePath();
		BeanUtils.copyProperties(filePathDto, filePath);
		return ResponseEntity.status(HttpStatus.CREATED).body(filePathService.saveNewFilePath(filePath));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
	@GetMapping
	public ResponseEntity<List<FilePath>> getAllFilePath() {
		return ResponseEntity.status(HttpStatus.OK).body(filePathService.listAllFilePath());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdFilePath(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(filePathService.findByIdFilePath(id));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteByIdFilePath(@PathVariable Long id) {
		filePathService.deleteByIdFilePath(id);
		return ResponseEntity.status(HttpStatus.OK).body("Caminho do arquivo excluído com sucesso.");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@PutMapping
	public ResponseEntity<Object> updateFilePath(@RequestBody @Valid FilePathDto filePathDto) {
		var filePath = new FilePath();
		BeanUtils.copyProperties(filePathDto, filePath);
		return ResponseEntity.status(HttpStatus.OK).body(filePathService.updateFilePath(filePath));
	}

}
