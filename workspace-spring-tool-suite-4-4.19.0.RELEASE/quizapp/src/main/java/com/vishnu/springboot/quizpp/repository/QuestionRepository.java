package com.vishnu.springboot.quizpp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vishnu.springboot.quizpp.entities.Question;

 public interface QuestionRepository extends JpaRepository<Question, Long> {
	 
	 @Query(value="select *from question where id=:id",nativeQuery=true)
	 public Question findByQuestionById(long id);
	 
	 
	 @Query(value="SELECT * FROM question ORDER BY RAND() LIMIT 3",nativeQuery=true)
	 public List<Question> generateRandomQuestions();

}
 
 
