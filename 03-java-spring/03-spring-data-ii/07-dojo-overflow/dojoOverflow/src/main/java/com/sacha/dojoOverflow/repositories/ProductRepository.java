package com.sacha.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.productsAndCategories.models.Products;

@Repository
public interface ProductRepository extends CrudRepository<Questions, Long>{
	List<Questions> findAll();
}