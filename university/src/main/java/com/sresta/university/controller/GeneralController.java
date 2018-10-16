package com.sresta.university.controller;

import javax.servlet.http.HttpServletRequest;
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
	public String home(HttpSession session, HttpServletRequest	request){
		try{
			if(session.getAttribute("isLoggedIn") == "LoggedIn"){
				String[] arr = request.getRequestURL().toString().split("/");
				String hostURL = arr[0] + "//" + arr[1] + "" + arr[2] + "/" + arr[3];
				session.setAttribute("hostURL", hostURL); 
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
