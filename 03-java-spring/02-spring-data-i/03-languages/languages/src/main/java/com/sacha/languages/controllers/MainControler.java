package com.sacha.languages.controllers;

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
import com.sacha.languages.models.Languages;
import com.sacha.languages.services.LanguageService;

@Controller
public class MainControler {

	@Autowired
	private LanguageService languageService;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newLanguages") Languages newLanguages, 
			Model model
			) {
		model.addAttribute("languages", languageService.getAllLanguages());
		return "index.jsp";
	}
	@GetMapping("/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model languageModel
			) {
		languageModel.addAttribute("language", languageService.getOneLanguage(id).orElseThrow(RuntimeException::new));
		return "details.jsp";
	}
	@GetMapping("/languages/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			Model languageModel
			) {
		languageModel.addAttribute("updateLanguage", languageService.getOneLanguage(id).orElseThrow(RuntimeException::new));
		return "edit.jsp";
	}
	@PostMapping("/create")
	public String create(
			@Valid 
			@ModelAttribute("newLanguages") Languages newLanguages, 
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else { 
			this.languageService.create(newLanguages);
			return "redirect:/";
		}
	}
	@PutMapping("languages/edit/{id}")
	public String update(
			@Valid 
			@ModelAttribute("updateLanguage") Languages updateLanguage, 
			BindingResult result,
<<<<<<< HEAD
			@PathVariable("id") Long id,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("language", languageService.getOneLanguage(id).orElseThrow(RuntimeException::new));
=======
			@PathVariable("id") Long id
			) {
		if(result.hasErrors()) {
>>>>>>> 1c3a708719f795d7b5f219980e88f9026bd15779
			return "edit.jsp";
		} 
		else {
			this.languageService.update(updateLanguage, id);
			return "redirect:/";
		}
	}
//	Delete a Student
	@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
        return "redirect:/";
    }
}
