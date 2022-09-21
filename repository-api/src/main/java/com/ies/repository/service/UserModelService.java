package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ies.repository.dto.UserModelDto;
import com.ies.repository.entity.UserModel;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userRepository;
	
	@Transactional
	public UserModel saveNewUser(UserModelDto userModelDto) {
		
		userModelDto.setPassword(new BCryptPasswordEncoder().encode(userModelDto.getPassword()));
		
		var userModel = new UserModel();
		BeanUtils.copyProperties(userModelDto, userModel);
		
		if (existsByRegistration(userModel.getRegistration())) {
			throw new BusinessException("Usuário com número de matrícula " + userModel.getRegistration() + " já cadastrado.");
		}
		return userRepository.save(userModel);
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
	
	public UserModel findByRegistration(Long id) {
		return userRepository.findByRegistration(id).orElseThrow(() -> new EntityNotFoundException("Usuário não cadastrado."));
	}
	
	@Transactional
	public void deleteByIdUser(Long id) {
		findByIdUser(id);
		userRepository.deleteById(id);
	}
	
	@Transactional
	public UserModel updateUser(UserModel user) {
		
		if (existsByRegistration(user.getRegistration())) {
			throw new BusinessException("Usuário com número de matrícula " + user.getRegistration() + " já cadastrado.");
		}
		
		if(findByIdUser(user.getIdUser()) == null) {
			throw new EntityNotFoundException("Usuário não cadastrado.");
		}
		
		return userRepository.save(user);
	}
	
	public Boolean existsByRegistration(Long registration) {
		return userRepository.existsByRegistration(registration);
	}
}
