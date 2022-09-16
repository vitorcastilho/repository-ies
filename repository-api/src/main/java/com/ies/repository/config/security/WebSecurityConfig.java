package com.ies.repository.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.httpBasic()
					.and()
						.authorizeHttpRequests()
							.antMatchers(HttpMethod.GET, "/").hasAnyRole("Admin", "Professor", "Aluno")
							.antMatchers(HttpMethod.POST, "/").hasAnyRole("Admin", "Professor")
							.antMatchers(HttpMethod.PUT, "/").hasAnyRole("Admin", "Professor")
							.antMatchers(HttpMethod.DELETE, "/").hasRole("Admin")
								.anyRequest()
								.authenticated()
									.and()
										.csrf()
										.disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
//			.inMemoryAuthentication()
//			.withUser("user")
//			.password(passwordEncoder()
//					.encode("senha"))
//					.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
