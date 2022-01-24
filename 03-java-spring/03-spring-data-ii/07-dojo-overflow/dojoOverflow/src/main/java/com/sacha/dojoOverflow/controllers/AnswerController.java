package com.sacha.dojoOverflow.controllers;

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
//import org.springframework.web.bind.annotation.RequestParam;

import com.sacha.dojoOverflow.models.Answers;
import com.sacha.dojoOverflow.models.Questions;
import com.sacha.dojoOverflow.services.AnswersService;
import com.sacha.dojoOverflow.services.QuestionsService;

@Controller
public class AnswerController {

	@Autowired
	private AnswersService aService;
	@Autowired
	private QuestionsService qService;

	@GetMapping("/categories")
	public String addCategory(
			@ModelAttribute("newCategory") Answers newCategory, 
			Model model
			) {
		model.addAttribute("categories", aService.getAllAnswers());
		return "addCategory.jsp";
	}
	@GetMapping("/category/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model model,
			HttpSession mySession
			) {
		
		mySession.setAttribute("cat_id", id);
		
		List<Questions> allProducts = qService.getAllQuestions();
		model.addAttribute("category", aService.getOneAnswer(id));
		model.addAttribute("products", allProducts);
		return "categoryDetails.jsp";
	}

	@PostMapping("/create")
	public String create(
			@Valid 
			@ModelAttribute("newCategory") Answers newCategory, 
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else { 
			this.aService.create(newCategory);
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
//	Delete an Answer
	@DeleteMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
		aService.deleteAnswer(id);
        return "redirect:/";
    }
}


