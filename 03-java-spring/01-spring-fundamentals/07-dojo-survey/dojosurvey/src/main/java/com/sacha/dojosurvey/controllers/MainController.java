package com.sacha.dojosurvey.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(Model model) {
		String[] languages= {"Java","Python","JavaScript", "PHP", "Ruby", "C#"};
		model.addAttribute("languages",languages);
		return "index.jsp";
	}
	
	@PostMapping("/welcome")
	public String welcome(@RequestParam("firstName") String fName,
			@RequestParam("location") String location,
			@RequestParam("language") String language,
			@RequestParam("comment") String comment,
			Model studentModel,
			HttpSession mySession
			) {
		studentModel.addAttribute("firstName",fName);
		studentModel.addAttribute("location",location);
		studentModel.addAttribute("language",language);
		studentModel.addAttribute("comment",comment);
		
		mySession.setAttribute("firstName", fName);
		System.out.println(studentModel.getAttribute("language"));
		if(studentModel.getAttribute("language").equals("Java")) {
			return "java.jsp";
		}else {
			return "welcome.jsp";
		}
		
	}
	@GetMapping("/details")
	public String details(HttpSession mySession) {
		return "details.jsp";
	}

}
