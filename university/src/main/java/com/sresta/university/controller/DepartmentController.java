package com.sresta.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.GET )
	public String studentHome(){
		return "/WEB-INF/pages/department/departmentHome.jsp";
	}

}
