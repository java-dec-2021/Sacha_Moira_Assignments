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
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")

public class Tags {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 2, max = 20, message="Product name should be between 2-20")
	private String tag;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		        name = "questions_and_tags", 
		        joinColumns = @JoinColumn(name = "tag_id"), 
		        inverseJoinColumns = @JoinColumn(name = "question_id")
		    )
    private List<Questions> questions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public List<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
}
