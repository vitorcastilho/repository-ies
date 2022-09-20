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

import com.ies.repository.dto.UserModelDto;
import com.ies.repository.entity.UserModel;
import com.ies.repository.service.UserModelService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/user")
public class UserModelController {

	@Autowired
	private UserModelService userService;
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PostMapping
	public ResponseEntity<Object> saveNewUser(@RequestBody @Valid UserModelDto userDto) {		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(userDto));
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<UserModel>> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.listAllUser());
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ALUNO', 'SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdUser(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByIdUser(id));
	}
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteByIdUser(@PathVariable Long id) {
		userService.deleteByIdUser(id);
		return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso.");
	}
	
	@PreAuthorize("hasAnyAuthority('SCOPE_PROFESSOR', 'SCOPE_ADMIN')")
	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody @Valid UserModelDto userDto) {
		var user = new UserModel();
		BeanUtils.copyProperties(userDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user));
	}
	
}
