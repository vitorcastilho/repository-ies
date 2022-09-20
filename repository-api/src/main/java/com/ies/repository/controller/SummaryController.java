package com.ies.repository.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.dto.SummaryDto;
import com.ies.repository.entity.Summary;
import com.ies.repository.service.SummaryService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/summary")
public class SummaryController {

	@Autowired
	private SummaryService summaryService;
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	public ResponseEntity<Object> saveNewSummary(@RequestBody @Valid SummaryDto summaryDto) {
		var summary = new Summary();
		BeanUtils.copyProperties(summaryDto, summary);
		return ResponseEntity.status(HttpStatus.CREATED).body(summaryService.saveNewSummary(summary));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdSummary(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(summaryService.findSummaryById(id));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateSummary(@RequestBody @Valid SummaryDto summaryDto) {
		var summary = new Summary();
		BeanUtils.copyProperties(summaryDto, summary);
		return ResponseEntity.status(HttpStatus.OK).body(summaryService.saveNewSummary(summary));
	}
}
