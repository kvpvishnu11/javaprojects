package com.vishnu.springboot.quizpp.dto;

import org.springframework.stereotype.Component;

@Component
public class QuestionSubmission {
	
	private int questionid;
	private String chooseanswer;
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getChooseanswer() {
		return chooseanswer;
	}
	public void setChooseanswer(String chooseanswer) {
		this.chooseanswer = chooseanswer;
	}
	

}
