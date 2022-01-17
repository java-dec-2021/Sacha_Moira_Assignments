package com.sacha.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue="Human") String name, 
			@RequestParam(value="lName", required=false) String lName,
			@RequestParam(value="num", required=false, defaultValue="1") int num,
			Model firstName,
			Model lastName,
			Model toLoop) {
		firstName.addAttribute("name", name);
		lastName.addAttribute("lName", lName);
		toLoop.addAttribute("num", num);
		return "whatever.jsp";
	}
}
