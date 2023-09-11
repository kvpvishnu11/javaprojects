package com.vishnu.springboot.quizpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.springboot.quizpp.entities.Quizusers;
import com.vishnu.springboot.quizpp.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Quizusers findByUsernameAndPassword(String username, String password) {
		
		return userRepository.findByUsernameAndPassword(username,password);
	}

	@Override
	public Quizusers saveUser(Quizusers qu) {
		
		return userRepository.save(qu);
	}

}
