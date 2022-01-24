package com.sacha.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.productsAndCategories.models.Categories;

@Repository
public interface CategoryRepository extends CrudRepository<Answers, Long>{
	List<Answers> findAll();
}