package com.sacha.languages.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacha.languages.models.Languages;
import com.sacha.languages.services.LanguageService;

@RestController
public class APIController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/api/languages")
	public List<Languages> languages() {
		return this.languageService.getAllLanguages();
	}
	@GetMapping("api/language")
	public Optional<Languages> oneLanguage(Long id){
		return this.languageService.getOneLanguage(id);
	}
	@PostMapping("/api/create")
	public Languages create(Languages newLanguage) {
		return this.languageService.create(newLanguage);
	}
	@Modifying
	@PutMapping("/api/update/{id}")
	public Languages update(@PathVariable("id")  Long id, Languages updateLanguage) {
		return this.languageService.update(updateLanguage, id);
	}
}
