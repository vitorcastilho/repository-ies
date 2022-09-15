package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.UserModel;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userRepository;
	
	@Transactional
	public UserModel saveNewUser(UserModel user) {
		if (existsByRegistration(user.getRegistration())) {
			throw new BusinessException("Usuário com número de matrícula " + user.getRegistration() + " já cadastrado.");
		}
		return userRepository.save(user);
	}
	
	public List<UserModel> listAllUser() {
		List<UserModel> userList =userRepository.findAll();
		if(userList.isEmpty()) {
			throw new EntityNotFoundException("Não existe usuário cadastrado.");
		}
		return userList;
	}
	
	public UserModel findByIdUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não cadastrado."));
	}
	
	@Transactional
	public void deleteByIdUser(Long id) {
		findByIdUser(id);
		userRepository.deleteById(id);
	}
	
	@Transactional
	public UserModel updateUser(UserModel user) {
		findByIdUser(user.getIdUser());
		return userRepository.save(user);
	}
	
	public Boolean existsByRegistration(Long registration) {
		return userRepository.existsByRegistration(registration);
	}
}
