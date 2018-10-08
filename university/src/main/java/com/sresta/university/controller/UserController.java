package com.sresta.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sresta.university.dao.UserDAO;
import com.sresta.university.entity.User;



@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserDAO udao;
	
	User user;
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<User> getAllUsers(){
		List<User> users = (List<User>) udao.getAll(User.class);
		
		return users;
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public User getUser(@RequestParam("var") String var, @RequestParam("value") String value){
		User student = (User) udao.get(var, value, User.class);
		return student;
	}

}
