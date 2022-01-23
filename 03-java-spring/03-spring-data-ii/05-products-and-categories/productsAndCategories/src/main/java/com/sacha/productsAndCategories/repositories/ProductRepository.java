package com.sacha.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.productsAndCategories.models.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long>{
	List<Products> findAll();
}