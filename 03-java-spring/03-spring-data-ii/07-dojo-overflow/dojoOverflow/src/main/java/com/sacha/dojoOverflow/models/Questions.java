package com.sacha.dojoOverflow.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")

public class Questions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 2, max = 200, message="Product name should be between 2-200")
	private String question;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		        name = "questions_tags", 
		        joinColumns = @JoinColumn(name = "questions_id"), 
		        inverseJoinColumns = @JoinColumn(name = "tags_id")
		    )
	private List<Tags> tags;
	 
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answers> answers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
}
