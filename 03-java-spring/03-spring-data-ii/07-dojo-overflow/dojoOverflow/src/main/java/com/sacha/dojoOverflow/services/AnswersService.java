package com.sacha.dojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.sacha.dojoOverflow.models.Answers;
//import com.sacha.dojoOverflow.models.Questions;
import com.sacha.dojoOverflow.repositories.AnswersRepository;
//import com.sacha.dojoOverflow.repositories.QuestionsRepository;

@Service
public class AnswersService {
	
	@Autowired
	private AnswersRepository aRepo;
//	@Autowired
//	private QuestionsRepository qRepo;
	
	public List<Answers> getAllAnswers(){
		return this.aRepo.findAll();
	}
	public Answers getOneAnswer(Long id){
		return this.aRepo.findById(id).orElse(null);
	}
	public Answers create(Answers newAnswer) {
		return this.aRepo.save(newAnswer);
	}
	@Modifying
	public Answers update(Answers updateAnswer, Long id) {
		return aRepo.save(updateAnswer);
	}	
	public void deleteAnswer(Long id) {
		this.aRepo.deleteById(id);
	}
//	public void addProduct(Answers Answer, Questions question) {
//		question.getAnswers().add(Answer);
//		qRepo.save(question);
//	}
}
