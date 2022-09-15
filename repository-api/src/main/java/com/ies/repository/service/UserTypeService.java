package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.UserType;
import com.ies.repository.enums.RoleName;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.UserTypeRepository;

@Service
public class UserTypeService {

	@Autowired
	private UserTypeRepository userTypeRepository;

	@Transactional
	public UserType saveUserType(UserType userType) {
		
		if ( existsByUserType(userType.getUserType())) {
			throw new BusinessException("Tipo de usuário já cadastrado!");
		}
		
		return userTypeRepository.save(userType);
	}

	public List<UserType> listAllUserType() {
		List<UserType> userTypeList = userTypeRepository.findAll();
		if (userTypeList.isEmpty()) {
			throw new EntityNotFoundException("Ainda não existe tipo de usuário cadastrado.");
		}
		return userTypeList;
	}

	public UserType findByIdUserType(Long id) {
		return userTypeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Tipo de usuário não cadastrado."));
	}
	
	@Transactional
	public Boolean deleteByIdUserType(Long id) {
		UserType userType = findByIdUserType(id);
		boolean valid = userType != null;
		
		if (!valid) {
			throw new EntityNotFoundException("Tipo de usuário não cadastrado.");
		}
		
		userTypeRepository.deleteById(id);
		
		return valid;
	}
	
	@Transactional
	public UserType updateUserType(UserType userType) {
		
		if (findByIdUserType(userType.getIdUserType()) == null) {
			throw new EntityNotFoundException("Tipo de usuário não cadastrado.");
		}
		
		return userTypeRepository.save(userType);
	}
	
	public boolean existsByUserType(RoleName roleName) {
		return userTypeRepository.existsByUserType(roleName);
	}

}
