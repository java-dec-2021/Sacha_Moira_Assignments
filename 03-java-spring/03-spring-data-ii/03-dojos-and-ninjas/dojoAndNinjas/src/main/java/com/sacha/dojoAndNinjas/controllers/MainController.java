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
public class MainController {

	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newDojo") Dojos newDojo, 
			Model model
			) {
		model.addAttribute("dojos", dojoService.getAllDojos());
		return "index.jsp";
	}
	@GetMapping("/details/{id}")
	public String details(
			@PathVariable("id") Long id, 
			Model model
			) {
		List<Ninjas> allNinjas = ninjaService.getAllNinjas();
		model.addAttribute("dojo", dojoService.getOneDojo(id).orElseThrow(RuntimeException::new));
		model.addAttribute("ninjas", allNinjas);
		return "dojoDetails.jsp";
	}
	@GetMapping("/dojo/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("updateDojo", dojoService.getOneDojo(id).orElseThrow(RuntimeException::new));
		return "editDojo.jsp";
	}
	@PostMapping("/create")
	public String create(
			@Valid 
			@ModelAttribute("newDojo") Dojos newDojo, 
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else { 
			this.dojoService.create(newDojo);
			return "redirect:/";
		}
	}
	@PutMapping("dojos/edit/{id}")
	public String update(
			@Valid 
			@ModelAttribute("updateDojo") Dojos updateDojo, 
			BindingResult result,
			@PathVariable("id") Long id,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("dojo", dojoService.getOneDojo(id).orElseThrow(RuntimeException::new));
			return "edit.jsp";
		} 
		else {
			this.dojoService.update(updateDojo, id);
			return "redirect:/";
		}
	}
//	Delete a Dojo
	@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
        return "redirect:/";
    }
}
