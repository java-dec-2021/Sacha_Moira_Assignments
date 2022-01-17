package com.sacha.dojoAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.dojoAndNinjas.models.Dojos;

@Repository
public interface DojoRepository extends CrudRepository<Dojos, Long>{
	List<Dojos> findAll();
}