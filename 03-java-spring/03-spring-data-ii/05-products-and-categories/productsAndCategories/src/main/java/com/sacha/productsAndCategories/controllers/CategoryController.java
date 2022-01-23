package com.sacha.productsAndCategories.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sacha.productsAndCategories.models.Categories;
import com.sacha.productsAndCategories.models.Products;
import com.sacha.productsAndCategories.services.CategoryService;
import com.sacha.productsAndCategories.services.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	@GetMapping("/categories")
	public String addCategory(
			@ModelAttribute("newCategory") Categories newCategory, 
			Model model
			) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "addCategory.jsp";
	}
	@GetMapping("/category/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model model,
			HttpSession mySession
			) {
		
		mySession.setAttribute("cat_id", id);
		
		List<Products> allProducts = productService.getAllProducts();
		model.addAttribute("category", categoryService.getOneCategory(id));
		model.addAttribute("products", allProducts);
		return "categoryDetails.jsp";
	}

	@PostMapping("/create")
	public String create(
			@Valid 
			@ModelAttribute("newCategory") Categories newCategory, 
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else { 
			this.categoryService.create(newCategory);
			return "redirect:/";
		}
	}
//		@GetMapping("/category/edit/{id}")
//	public String update(
//			@PathVariable("id") Long id,
//			Model model
//			) {
//		model.addAttribute("updateCategory", categoryService.getOneCategory(id).orElseThrow(RuntimeException::new));
//		return "editCategory.jsp";
//	}
//	@PutMapping("categories/edit/{id}")
//	public String update(
//			@Valid 
//			@ModelAttribute("updateDojo") Categories updateCategory, 
//			BindingResult result,
//			@PathVariable("id") Long id,
//			Model model
//			) {
//		if(result.hasErrors()) {
//			model.addAttribute("category", categoryService.getOneCategory(id).orElseThrow(RuntimeException::new));
//			return "edit.jsp";
//		} 
//		else {
//			this.categoryService.update(updateCategory, id);
//			return "redirect:/";
//		}
//	}
//	Delete a Category
	@DeleteMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
        return "redirect:/";
    }

	@GetMapping("/category/addProduct")
	public String addCategory(
			@RequestParam("prodId") Long product_id,
			HttpSession mySession,
			Model model
			) {
		
		Long category_id = (Long)mySession.getAttribute("cat_id");
		Categories Category= categoryService.getOneCategory(category_id);
		Products Product = productService.getOneProduct(product_id);
		categoryService.addProduct(Category, Product);
		
		model.addAttribute("category", categoryService.getOneCategory(category_id));
		model.addAttribute("products", productService.getAllProducts());
		
		return "categoryDetails.jsp";
	}
}


