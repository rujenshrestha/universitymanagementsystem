package com.sresta.university.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	
	@RequestMapping(value={"", "/"})
	public String index(){
		return "/home"; 
	}    
	
	@RequestMapping(value={"/home"})
	public String home(HttpSession session){
		try{
			if(session.getAttribute("isLoggedIn") == "LoggedIn"){
				return "/WEB-INF/pages/dashboard.jsp"; 
			}else{
				System.out.println(session.getAttribute("msg"));
				return "/login"; 
			}
		}catch(Exception e){
			System.out.println("Session is not set");
			return "/login"; 
		}
		
	}   


}
