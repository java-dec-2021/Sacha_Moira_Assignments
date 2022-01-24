package com.sacha.dojoOverflow.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sacha.productsAndCategories.models.Categories;
import com.sacha.productsAndCategories.models.Products;
import com.sacha.productsAndCategories.services.CategoryService;
import com.sacha.productsAndCategories.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private CategoryService cService;
	
	@Autowired
	private ProductService pService;

	@GetMapping("/")
	public String index(
			Model model
			) {
		model.addAttribute("products", pService.getAllProducts());
		model.addAttribute("allCategories", cService.getAllCategories());
		return "index.jsp";
	}
	@GetMapping("/product/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model model,
			HttpSession mySession
			) {
		model.addAttribute("product", pService.getOneProduct(id));
		model.addAttribute("allCategories", cService.getAllCategories());
		mySession.setAttribute("prod_id", id);
		return "productDetails.jsp";
	}
	@GetMapping("/product/create")
	public String addProduct(@ModelAttribute("newProduct") Questions newProduct) {
		return "addProduct.jsp";
	}
	@PostMapping("/product/create")
	public String create(
			@Valid 
			@ModelAttribute("newProduct") Questions newProduct, 
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return "addProduct.jsp";
		} 
		else { 
			this.pService.create(newProduct);
			return "redirect:/product/details/" + newProduct.getId();
		}
	}
		@GetMapping("/product/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("updateProduct", pService.getOneProduct(id));
		return "editProduct.jsp";
	}
	@PutMapping("product/edit/{id}")
	public String update(
			@Valid 
			@ModelAttribute("updateProduct") Questions updateProduct, 
			BindingResult result,
			@PathVariable("id") Long id,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("product", pService.getOneProduct(id));
			return "edit.jsp";
		} 
		else {
			this.pService.update(updateProduct, id);
			return "redirect:/";
		}
	}
//	Delete a Product
	@DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
		this.pService.deleteProduct(id);
        return "redirect:/";
    }
	
	@GetMapping("/product/addCategory")
	public String addCategory(
			@RequestParam("catId") Long category_id,
			HttpSession mySession,
			Model model
			) {
		
		Long product_id = (Long)mySession.getAttribute("prod_id");
		Questions Product = pService.getOneProduct(product_id);
		Answers Category = cService.getOneCategory(category_id);
		pService.addCategory(Product, Category);
		
		model.addAttribute("product", pService.getOneProduct(product_id));
		model.addAttribute("allCategories", cService.getAllCategories());
		
		return "productDetails.jsp";
	}
}
