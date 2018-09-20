package com.sresta.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	
	@RequestMapping(value={"", "/", "home"})
	public String home(){
		return "/WEB-INF/pages/dashboard.jsp"; 
	}  


}
