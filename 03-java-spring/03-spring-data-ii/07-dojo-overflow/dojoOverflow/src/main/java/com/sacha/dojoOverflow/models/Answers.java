package com.sacha.dojoOverflow.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="answers")

public class Answers {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
    private Long id;
	
	@Size(min = 2, max = 20, message="Language should be between 2-200")
	private String answer;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "question_id")
		
    private Questions question;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
}
