package com.sacha.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.dojoOverflow.models.Tags;

@Repository
public interface TagsRepository extends CrudRepository<Tags, Long>{
	List<Tags> findAll();
}