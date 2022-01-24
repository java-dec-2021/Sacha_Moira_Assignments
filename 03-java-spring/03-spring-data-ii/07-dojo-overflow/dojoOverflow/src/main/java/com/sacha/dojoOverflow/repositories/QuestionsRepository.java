package com.sacha.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.dojoOverflow.models.Questions;

@Repository
public interface QuestionsRepository extends CrudRepository<Questions, Long>{
	List<Questions> findAll();
}