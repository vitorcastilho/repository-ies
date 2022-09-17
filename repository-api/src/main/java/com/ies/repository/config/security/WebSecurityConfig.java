package com.ies.repository.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.httpBasic()
				.and()
				.authorizeHttpRequests()
				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable();
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

//							.antMatchers(HttpMethod.GET, "/").hasAnyRole("Admin", "Professor", "Aluno")
//							.antMatchers(HttpMethod.POST, "/").hasAnyRole("Admin", "Professor")
//							.antMatchers(HttpMethod.PUT, "/").hasAnyRole("Admin", "Professor")
//							.antMatchers(HttpMethod.DELETE, "/").hasRole("Admin")