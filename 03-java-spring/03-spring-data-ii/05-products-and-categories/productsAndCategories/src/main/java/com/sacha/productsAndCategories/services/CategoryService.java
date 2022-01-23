package com.sacha.productsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.sacha.productsAndCategories.models.Categories;
import com.sacha.productsAndCategories.models.Products;
import com.sacha.productsAndCategories.repositories.CategoryRepository;
import com.sacha.productsAndCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;
	
	public List<Categories> getAllCategories(){
		return this.categoryRepo.findAll();
	}
	public Categories getOneCategory(Long id){
		return this.categoryRepo.findById(id).orElse(null);
	}
	public Categories create(Categories newCategory) {
		return this.categoryRepo.save(newCategory);
	}
	@Modifying
	public Categories update(Categories updateCategory, Long id) {
		return categoryRepo.save(updateCategory);
	}	
	public void deleteCategory(Long id) {
		this.categoryRepo.deleteById(id);
	}
	public void addProduct(Categories Category, Products product) {
		product.getCategories().add(Category);
		productRepo.save(product);
	}
}
