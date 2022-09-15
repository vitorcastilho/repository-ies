package com.ies.repository.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long> {

	Boolean existsByRegistration(Long registration);
	
	Optional<UserModel> findByRegistration(Long registration);

}
