package com.sresta.university.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sresta.university.dao.UserDAO;
import com.sresta.university.entity.User;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	UserDAO udao;
	
	@RequestMapping(value={"", "/"}, method = RequestMethod.GET )
	public String loginForm(HttpSession session){
		if(session.getAttribute("isLoggedIn") == "LoggedIn"){
			return "/home";
		}
		return "/WEB-INF/pages/login/login.jsp";
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.GET )
	public String login(@RequestParam("username") String username, 
						@RequestParam("password") String password, 
						HttpSession session){
		
		User user = udao.loginUser(username, password);
		if(user != null){
			System.out.println(user.getName());
			session.setAttribute("userId",user.getUserId());
			session.setAttribute("ssn", user.getSsn());
			session.setAttribute("name", user.getName());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("isLoggedIn", "LoggedIn");

			
		}else{
			System.out.println("User is NULL");
			session.setAttribute("msg", "Incorrect Username or Password");
			session.removeAttribute("isLoggedIn");
		}
		
		return "/home"; 
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.setAttribute("isLoggedIn", "loggedOut");
		return "/WEB-INF/pages/login/logout.jsp";
	}
}
