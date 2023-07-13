package com.vishnu.springboot.quizpp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.springboot.quizpp.dto.QuestionSubmission;
import com.vishnu.springboot.quizpp.entities.Question;
import com.vishnu.springboot.quizpp.repository.QuestionRepository;

@Component
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public QuestionRepository getQuestionRepository() {
		return questionRepository;
	}

	public void setQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public List<Question> getAllQuestions() {
		 
		return questionRepository.findAll();
	}

	@Override
	public Question saveQuestion(Question q) {
		
		 
		return questionRepository.save(q);
	}

	@Override
	public Question getAnswerFromQuestion(long q) {
		
		
		return questionRepository.findByQuestionById(q);
	}

	@Override
	public List<Question> saveAllQuesitons(List<Question> q) {
		 
		return questionRepository.saveAll(q);
	}

	@Override
	public List<Question> getRandomQs() {
		 
		return questionRepository.generateRandomQuestions();
	}

	@Override
	public int calculateMarks(List<QuestionSubmission> qs) {
		int total=0;
		 
		for(QuestionSubmission qr : qs) {
			
			Question q = questionRepository.findByQuestionById(qr.getQuestionid());
			System.out.println(" Choosen Answer  = "+qr.getChooseanswer());
			System.out.println(" Question id = "+q.getId());
			System.out.println(" Correct Answer  = "+q.getRightAnswer());
			
			if(qr.getChooseanswer().equals(q.getRightAnswer())) {
				total++;
			}
			 
		}
		
		return total;
	}
	

}
