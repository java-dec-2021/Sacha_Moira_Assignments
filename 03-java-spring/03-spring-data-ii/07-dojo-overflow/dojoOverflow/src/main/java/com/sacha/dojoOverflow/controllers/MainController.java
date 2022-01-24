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

import com.sacha.dojoOverflow.models.Questions;
import com.sacha.dojoOverflow.models.Tags;
import com.sacha.dojoOverflow.services.AnswersService;
import com.sacha.dojoOverflow.services.QuestionsService;
import com.sacha.dojoOverflow.services.TagsService;

@Controller
public class MainController {

	@Autowired
	private AnswersService aService;
	@Autowired
	private QuestionsService qService;
	@Autowired
	private TagsService tService;

	@GetMapping("/")
	public String index(
			Model model
			) {
		model.addAttribute("questions", qService.getAllQuestions());
		model.addAttribute("allCategories", aService.getAllAnswers());
		return "index.jsp";
	}
	@GetMapping("/question/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model model,
			HttpSession mySession
			) {
		model.addAttribute("question", qService.getOneQuestion(id));
		model.addAttribute("allCategories", aService.getAllAnswers());
		mySession.setAttribute("quest_id", id);
		return "questionDetails.jsp";
	}
	@GetMapping("/question/create")
	public String addQuestion(@ModelAttribute("newQuestion") Questions newQuestion) {
		return "addQuestion.jsp";
	}
	@PostMapping("/question/create")
	public String create(
			@Valid 
			@ModelAttribute("newQuestion") Questions newQuestion, 
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return "addQuestion.jsp";
		} 
		else { 
			this.qService.create(newQuestion);
			return "redirect:/question/details/" + newQuestion.getId();
		}
	}
		@GetMapping("/question/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("updateQuestion", qService.getOneQuestion(id));
		return "editQuestion.jsp";
	}
	@PutMapping("question/edit/{id}")
	public String update(
			@Valid 
			@ModelAttribute("updateQuestion") Questions updateQuestion, 
			BindingResult result,
			@PathVariable("id") Long id,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("question", qService.getOneQuestion(id));
			return "edit.jsp";
		} 
		else {
			this.qService.update(updateQuestion, id);
			return "redirect:/";
		}
	}
//	Delete a Product
	@DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") Long id) {
		this.qService.deleteQuestion(id);
        return "redirect:/";
    }
	
	@GetMapping("/question/addCategory")
	public String addCategory(
			@RequestParam("catId") Long category_id,
			HttpSession mySession,
			Model model
			) {
		
		Long question_id = (Long)mySession.getAttribute("quest_id");
		Questions Question = qService.getOneQuestion(question_id);
		Tags Tag = tService.getOneTag(category_id);
		qService.addTag(Question, Tag);
		
		model.addAttribute("question", qService.getOneQuestion(question_id));
		model.addAttribute("allCategories", tService.getAllTags());
		
		return "questionDetails.jsp";
	}
}
