package com.sacha.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(){		
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String displayDate(Model dateModel){
		SimpleDateFormat dotw = new SimpleDateFormat("EEEE");
		SimpleDateFormat monthDate = new SimpleDateFormat("dd");
		SimpleDateFormat mny = new SimpleDateFormat("MMMM, yyyy");

		String day = dotw.format(new Date());
		String dotm = monthDate.format(new Date());
		String monthYear = mny.format(new Date());
		String date = day + ", the " + dotm + " of " + monthYear;
		
		dateModel.addAttribute("date", date);		
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String displayTime(Model timeModel){
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm aa");
		String time = stf.format(new Date());

		timeModel.addAttribute("time", time);
		return "time.jsp";
	}
}
