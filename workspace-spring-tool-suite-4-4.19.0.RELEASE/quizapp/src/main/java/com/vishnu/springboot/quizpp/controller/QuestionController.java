package com.vishnu.springboot.quizpp.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.springboot.quizpp.dto.QuestionSubmission;
import com.vishnu.springboot.quizpp.dto.Result;
import com.vishnu.springboot.quizpp.entities.Question;
import com.vishnu.springboot.quizpp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	
	// GET ALL QUESTIONS
	
	@GetMapping("/")
	public List<Question> getAllQstns() {
		return questionService.getAllQuestions();
	}
	
	// POST ONLY SINGLE QUESTION
//	
//	@PostMapping("/")
//	
//	public Question saveQstn(@RequestBody Question qstn) {
//		
//		Question q1 = questionService.saveQuestion(qstn);
//		
//		return q1;
//		
//	}
	
	// GET ANSWER BY THE ID 
	
	@GetMapping("/{q1}")
	public Question getAnswerByQuestion(@PathVariable long q1) {
		
		Question q2 = questionService.getAnswerFromQuestion(q1);
		
		return q2;
		
	}

	
	// POST MULTIPLE QUESTIONS AT ONE GO.
	
	@PostMapping("/")
	public List<Question> saveMultipleQstns(@RequestBody List<Question> multipleqstns){
		
		return questionService.saveAllQuesitons(multipleqstns);
	}
	
	// GET SOME RANDOM QUESTIONS EVERY TIME
	//@CrossOrigin(origins="http://127.0.0.1:5500")
	@GetMapping("/random/")
	public List<Question> getRandomQstns(){
		
		return questionService.getRandomQs();
	}
	
	
	@PostMapping("/submitquiz/")
	public ResponseEntity<Result> submitAndCalculateMarks(@RequestBody List<QuestionSubmission> qs){
		
		 
		Result result=new Result();
		result.setMarks(questionService.calculateMarks(qs)) ;
		
		System.out.println(" Got Marks = "+result.getMarks());
		
	    return ResponseEntity.ok(result);
	}
	
}
