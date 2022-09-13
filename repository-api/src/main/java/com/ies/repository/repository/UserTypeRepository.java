package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

	boolean existsByUserType(String userType);

}
