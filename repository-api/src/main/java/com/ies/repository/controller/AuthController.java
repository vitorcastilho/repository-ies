package com.ies.repository.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.service.TokenService;

@RestController
//@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping
public class AuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	
	private final TokenService tokenService;	
	
	public AuthController(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@PostMapping("/login")
	public String token(Authentication authentication) {
		LOG.debug("Token request for user: '{}'", authentication.getName());
		String token = tokenService.generateToken(authentication);
		LOG.debug("Token granted '{}'", token);
		return token;
	}

}
