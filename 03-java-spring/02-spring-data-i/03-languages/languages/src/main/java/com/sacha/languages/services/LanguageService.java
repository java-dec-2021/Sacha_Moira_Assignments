package com.sacha.languages.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import com.sacha.languages.models.Languages;
import com.sacha.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepo;
	
	public List<Languages> getAllLanguages(){
		return this.languageRepo.findAll();
	}
	public Optional<Languages> getOneLanguage(Long id){
		return this.languageRepo.findById(id);
	}
	public Languages create(Languages newLanguage) {
		return this.languageRepo.save(newLanguage);
	}
	@Modifying
	public Languages update(Languages updateLanguage, Long id) {
		return languageRepo.save(updateLanguage);
	}	
	public void deleteLanguage(Long id) {
		this.languageRepo.deleteById(id);
	}
}
