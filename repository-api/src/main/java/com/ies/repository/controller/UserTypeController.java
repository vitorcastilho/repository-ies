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

import com.ies.repository.dto.UserTypeDto;
import com.ies.repository.entity.UserType;
import com.ies.repository.service.UserTypeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user-type")
public class UserTypeController {

	private UserTypeService userTypeService;

	public UserTypeController(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}

	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	public ResponseEntity<Object> saveNewUserType(@RequestBody @Valid UserTypeDto userTypeDto) {
		var userType = new UserType();
		BeanUtils.copyProperties(userTypeDto, userType);
		return ResponseEntity.status(HttpStatus.CREATED).body(userTypeService.saveUserType(userType));
	}

	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<UserType>> getAllUserType() {
		return ResponseEntity.status(HttpStatus.OK).body(userTypeService.listAllUserType());
	}

	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdUserType(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findByIdUserType(id));
	}
	
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUserTypeById(@PathVariable Long id) {
		userTypeService.deleteByIdUserType(id);
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de Usuário excluído com sucesso.");
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateUserType(@RequestBody @Valid UserTypeDto userTypeDto) {
		var userType = new UserType();
		BeanUtils.copyProperties(userTypeDto, userType);
		return ResponseEntity.status(HttpStatus.OK).body(userTypeService.updateUserType(userType));
	}

}
