package com.vishnu.springboot.quizpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vishnu.springboot.quizpp.entities.Quizusers;

public interface UserRepository extends JpaRepository<Quizusers, Long> {
	
	@Query(value="SELECT * FROM Quizusers WHERE username = :username AND password = :password",nativeQuery=true)
	public Quizusers findByUsernameAndPassword(String username, String password);


}
