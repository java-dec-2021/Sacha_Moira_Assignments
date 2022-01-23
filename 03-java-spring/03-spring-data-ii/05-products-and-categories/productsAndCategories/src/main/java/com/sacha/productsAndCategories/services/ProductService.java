package com.sacha.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.sacha.productsAndCategories.models.Categories;
import com.sacha.productsAndCategories.models.Products;
import com.sacha.productsAndCategories.repositories.CategoryRepository;
import com.sacha.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Products> getAllProducts(){
		return this.productRepo.findAll();
	}
	public Products getOneProduct(Long id){
		return this.productRepo.findById(id).orElse(null);
	}
	public Products create(Products newProduct) {
		return this.productRepo.save(newProduct);
	}
	@Modifying
	public Products update(Products updateProduct, Long id) {
		return productRepo.save(updateProduct);
	}	
	public void deleteProduct(Long id) {
		this.productRepo.deleteById(id);
	}
	public void addCategory(Products Product, Categories category) {
		category.getProducts().add(Product);
		categoryRepo.save(category);
	}
}
