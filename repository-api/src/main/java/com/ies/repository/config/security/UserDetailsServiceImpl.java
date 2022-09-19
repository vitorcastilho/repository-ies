package com.ies.repository.config.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.UserModel;
import com.ies.repository.repository.UserModelRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserModelRepository userRepository;	
	
	public UserDetailsServiceImpl(UserModelRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Long registration = Long.parseLong(userName);
		
		UserModel userModel = userRepository.findByRegistration(registration)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não cadastrado!"));
		System.out.println("userModel: " + userModel);
		return new User(userModel.getRegistration().toString(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
	}

}
