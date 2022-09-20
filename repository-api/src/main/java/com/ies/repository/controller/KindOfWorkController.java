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

import com.ies.repository.dto.KindOfWorkDto;
import com.ies.repository.entity.KindOfWork;
import com.ies.repository.service.KindOfWorkService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/kind-of-work")
public class KindOfWorkController {

	@Autowired
	private KindOfWorkService kindOfWorkService;
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	public ResponseEntity<Object> saveNewKindOfWork(@RequestBody @Valid KindOfWorkDto kindOfWorkDto) {
		var kindOfWork = new KindOfWork();
		BeanUtils.copyProperties(kindOfWorkDto, kindOfWork);
		return ResponseEntity.status(HttpStatus.CREATED).body(kindOfWorkService.saveNewKindOfWork(kindOfWork));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<KindOfWork>> getAllKindOfWork() {
		return ResponseEntity.status(HttpStatus.OK).body(kindOfWorkService.listAllKindOfWork());
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdKindOfWork(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(kindOfWorkService.findByIdKindOfWork(id));
	}
	
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> saveNewKindOfWork(@PathVariable Long id) {
		kindOfWorkService.deleteByIdKindOfWork(id);
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de trabalho excluído com sucesso");
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateKindOfWork(@RequestBody @Valid KindOfWorkDto kindOfWorkDto) {
		var kindOfWork = new KindOfWork();
		BeanUtils.copyProperties(kindOfWorkDto, kindOfWork);
		return ResponseEntity.status(HttpStatus.OK).body(kindOfWorkService.updateKindOfWork(kindOfWork));
	}
}
