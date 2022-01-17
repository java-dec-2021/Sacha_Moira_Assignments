package com.sacha.dojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.sacha.dojoAndNinjas.models.Dojos;
import com.sacha.dojoAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojos> getAllDojos(){
		return this.dojoRepo.findAll();
	}
	public Optional<Dojos> getOneDojo(Long id){
		return this.dojoRepo.findById(id);
	}
	public Dojos create(Dojos newDojo) {
		return this.dojoRepo.save(newDojo);
	}
	@Modifying
	public Dojos update(Dojos updateDojo, Long id) {
		return dojoRepo.save(updateDojo);
	}	
	public void deleteDojo(Long id) {
		this.dojoRepo.deleteById(id);
	}
}
