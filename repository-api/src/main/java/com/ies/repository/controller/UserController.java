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

import com.ies.repository.dto.UserDto;
import com.ies.repository.entity.User;
import com.ies.repository.service.UserService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> saveNewUser(@RequestBody @Valid UserDto userDto) {
		var user = new User();
		BeanUtils.copyProperties(userDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(user));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.listAllUser());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdUser(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByIdUser(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteByIdUser(@PathVariable Long id) {
		userService.deleteByIdUser(id);
		return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso.");
	}
	
	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody @Valid UserDto userDto) {
		var user = new User();
		BeanUtils.copyProperties(userDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user));
	}
	
}
