package com.sacha.dojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.sacha.dojoAndNinjas.models.Ninjas;
import com.sacha.dojoAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninjas> getAllNinjas(){
		return this.ninjaRepo.findAll();
	}
	public Optional<Ninjas> getOneNinja(Long id){
		return this.ninjaRepo.findById(id);
	}
	public Ninjas create(Ninjas newNinja) {
		return this.ninjaRepo.save(newNinja);
	}
	@Modifying
	public Ninjas update(Ninjas updateNinja, Long id) {
		return ninjaRepo.save(updateNinja);
	}	
	public void deleteNinja(Long id) {
		this.ninjaRepo.deleteById(id);
	}
}
