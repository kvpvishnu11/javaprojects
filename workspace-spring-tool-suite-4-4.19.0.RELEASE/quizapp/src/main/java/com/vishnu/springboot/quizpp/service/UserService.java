package com.vishnu.springboot.quizpp.service;

import com.vishnu.springboot.quizpp.entities.Quizusers;

public interface UserService {
	
	public Quizusers findByUsernameAndPassword(String username, String password);
	
	public Quizusers saveUser(Quizusers qu);

}
