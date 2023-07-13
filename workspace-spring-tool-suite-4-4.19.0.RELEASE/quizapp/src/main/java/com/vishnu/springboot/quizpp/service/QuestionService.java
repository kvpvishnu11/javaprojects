package com.vishnu.springboot.quizpp.service;

import java.util.List;

import com.vishnu.springboot.quizpp.dto.QuestionSubmission;
import com.vishnu.springboot.quizpp.entities.Question;

public interface QuestionService {
	
	public List<Question> getAllQuestions();
	public Question saveQuestion(Question q);
	
	public Question getAnswerFromQuestion(long q);
	
	public List<Question> saveAllQuesitons(List<Question> q);
	
	public List<Question> getRandomQs();
	
	public int calculateMarks(List<QuestionSubmission> qs);
}
