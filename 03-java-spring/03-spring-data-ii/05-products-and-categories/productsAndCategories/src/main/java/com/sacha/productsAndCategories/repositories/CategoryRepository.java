package com.sacha.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.productsAndCategories.models.Categories;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, Long>{
	List<Categories> findAll();
}