package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByRegistration(Long registration);

}
