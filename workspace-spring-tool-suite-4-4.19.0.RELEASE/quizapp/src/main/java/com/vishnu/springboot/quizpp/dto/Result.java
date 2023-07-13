package com.vishnu.springboot.quizpp.dto;

import org.springframework.stereotype.Component;

@Component
public class Result {
	
	private int marks;

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
