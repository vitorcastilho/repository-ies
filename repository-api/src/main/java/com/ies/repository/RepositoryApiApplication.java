package com.ies.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ies.repository.config.security.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class RepositoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApiApplication.class, args);
		System.out.println("senhaParaTeste: " + new BCryptPasswordEncoder().encode("senhaParaTeste"));
	}

}
