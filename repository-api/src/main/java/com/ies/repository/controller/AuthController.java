package com.ies.repository.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.entity.UserModel;
import com.ies.repository.response.JwtResponse;
import com.ies.repository.service.TokenService;
import com.ies.repository.service.UserModelService;

@RestController
//@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping
public class AuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	
	private final TokenService tokenService;
	
	private UserModelService userModelService;
	
	public AuthController(TokenService tokenService, UserModelService userModelService) {
		this.tokenService = tokenService;
		this.userModelService = userModelService;
	}
	
	@PostMapping("/token")
	public String token(Authentication authentication) {
		LOG.debug("Token request for user: '{}'", authentication.getName());
		String token = tokenService.generateToken(authentication);
		LOG.debug("Token granted '{}'", token);
		return token;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser2(Authentication authentication) {
		LOG.debug("Token request for user: '{}'", authentication.getName());
		String token = tokenService.generateToken(authentication);
		LOG.debug("Token granted '{}'", token);
		
		UserModel userModel = userModelService.findByRegistration(Long.parseLong(authentication.getName()));
	
		
		return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(
																		token, 
																		userModel.getIdUser(), 
																		userModel.getRegistration(), 
																		userModel.getEmail(),
																		userModel.getName(),
																		userModel.getUserType()));
	}

}
