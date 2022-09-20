package com.ies.repository.controller;

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

import com.ies.repository.dto.TagDto;
import com.ies.repository.entity.Tag;
import com.ies.repository.service.TagService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	public ResponseEntity<Object> saveNewTag(@RequestBody @Valid TagDto tagDto) {
		var tag = new Tag();
		BeanUtils.copyProperties(tagDto, tag);
		return ResponseEntity.status(HttpStatus.CREATED).body(tagService.saveNewTag(tag));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdTag(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(tagService.findByIdTag(id));
	}
	
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTag(@PathVariable Long id) {
		tagService.deleteByIdTag(id);
		return ResponseEntity.status(HttpStatus.OK).body("Tag excluída com sucesso.");
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateTag(@RequestBody @Valid TagDto tagDto) {
		var tag = new Tag();
		BeanUtils.copyProperties(tagDto, tag);
		return ResponseEntity.status(HttpStatus.OK).body(tagService.saveNewTag(tag));
	}
}
