package com.sacha.dojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.sacha.dojoOverflow.models.Questions;
import com.sacha.dojoOverflow.models.Tags;
import com.sacha.dojoOverflow.repositories.QuestionsRepository;
import com.sacha.dojoOverflow.repositories.TagsRepository;

@Service
public class TagsService {
	
	@Autowired
	private TagsRepository tRepo;
	@Autowired
	private QuestionsRepository qRepo;

	public List<Tags> getAllTags(){
		return this.tRepo.findAll();
	}
	public Tags getOneTag(Long id){
		return this.tRepo.findById(id).orElse(null);
	}
	public Tags create(Tags newTag) {
		return this.tRepo.save(newTag);
	}
	@Modifying
	public Tags update(Tags updateTag, Long id) {
		return tRepo.save(updateTag);
	}	
	public void deleteProduct(Long id) {
		this.tRepo.deleteById(id);
	}
	public void addCategory(Tags Tag, Questions question) {
	question.getTags().add(Tag);
	qRepo.save(question);
	}

}
