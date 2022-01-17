package com.sacha.dojoAndNinjas.controllers;

import java.util.List;

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

import com.sacha.dojoAndNinjas.models.Dojos;
import com.sacha.dojoAndNinjas.models.Ninjas;
import com.sacha.dojoAndNinjas.services.DojoService;
import com.sacha.dojoAndNinjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;

	@GetMapping("/ninjas")
	public String addNinja(
			@ModelAttribute("newNinja") Ninjas newNinja,
			Model model
			) {
//		List<Dojos> allDojos = this.dService.getAllDojos();
		model.addAttribute("ninjas", nService.getAllNinjas());
		model.addAttribute("allDojos", dService.getAllDojos());
		return "addNinja.jsp";
	}
	@GetMapping("/ninja/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model model
			) {
		model.addAttribute("dojo", nService.getOneNinja(id).orElseThrow(RuntimeException::new));
		return "ninjaDetails.jsp";
	}
	@GetMapping("/ninja/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("updateNinja", nService.getOneNinja(id).orElseThrow(RuntimeException::new));
		return "editNinja.jsp";
	}
	@PostMapping("/ninja/create")
	public String create(
			@Valid 
			@ModelAttribute("newNinja") Ninjas newNinja, 
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else { 
			this.nService.create(newNinja);
			return "redirect:/";
		}
	}
	@PutMapping("ninja/edit/{id}")
	public String update(
			@Valid 
			@ModelAttribute("updateNinja") Ninjas updateNinja, 
			BindingResult result,
			@PathVariable("id") Long id,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("ninja", nService.getOneNinja(id).orElseThrow(RuntimeException::new));
			return "edit.jsp";
		} 
		else {
			this.nService.update(updateNinja, id);
			return "redirect:/";
		}
	}
//	Delete a Ninja
	@DeleteMapping("/ninja/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
		nService.deleteNinja(id);
        return "redirect:/ninjas";
    }
}
