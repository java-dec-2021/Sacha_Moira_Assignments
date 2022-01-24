package com.sacha.dojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

//import com.sacha.dojoOverflow.models.Answers;
import com.sacha.dojoOverflow.models.Questions;
import com.sacha.dojoOverflow.models.Tags;
//import com.sacha.dojoOverflow.repositories.AnswersRepository;
import com.sacha.dojoOverflow.repositories.QuestionsRepository;
import com.sacha.dojoOverflow.repositories.TagsRepository;

@Service
public class QuestionsService {
	
	@Autowired
	private QuestionsRepository qRepo;
//	@Autowired
//	private AnswersRepository aRepo;
	@Autowired
	private TagsRepository tRepo;
	
	public List<Questions> getAllQuestions(){
		return this.qRepo.findAll();
	}
	public Questions getOneQuestion(Long id){
		return this.qRepo.findById(id).orElse(null);
	}
	public Questions create(Questions newQuestion) {
		return this.qRepo.save(newQuestion);
	}
	@Modifying
	public Questions update(Questions updateQuestion, Long id) {
		return qRepo.save(updateQuestion);
	}	
	public void deleteQuestion(Long id) {
		this.qRepo.deleteById(id);
	}
	public void addTag(Questions Question, Tags tag) {
	tag.getQuestions().add(Question);
	tRepo.save(tag);
}
//	public void addCategory(Questions Product, Answers category) {
//		category.getQuestion().add(Product);
//		aRepo.save(category);
//	}
}
