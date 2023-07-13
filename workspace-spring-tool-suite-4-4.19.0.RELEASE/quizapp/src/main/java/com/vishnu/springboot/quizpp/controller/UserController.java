package com.vishnu.springboot.quizpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.springboot.quizpp.entities.Quizusers;
import com.vishnu.springboot.quizpp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/save/")
	public Quizusers saveTheUser(@RequestBody Quizusers qu) {
		
		 Quizusers qu1 = userService.saveUser(qu);
		return qu1;
	}
	
	@PostMapping("/users/check/")
	public ResponseEntity<?> checkIfUserIsPresent(@RequestBody Quizusers qu) {
	    Quizusers user = userService.findByUsernameAndPassword(qu.getUsername(), qu.getPassword());
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");
	    } else {
	        return ResponseEntity.ok(user);
	    }
	}

}
