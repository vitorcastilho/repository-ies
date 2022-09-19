package com.ies.repository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.service.UserModelService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/login")
public class AuthController {
	
	@Autowired
	private UserModelService userModelService;
	
	@GetMapping
	@PreAuthorize(value = "permitAll()")
	public String home() {
		return "Home Page123";
	}
	
	@GetMapping("/aluno")
	@PreAuthorize("hasRole('ROLE_ALUNO')")
	public String user() {
		return "Aluno Page";
	}
	
	@GetMapping("/professor")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String profile() {
		return "Professor Page";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "Admin Page";
	}	

}
