package com.sresta.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sresta.university.dao.FacultyDAO;
import com.sresta.university.entity.Faculty;

@Controller
@RequestMapping("faculty")
public class FacultyController {
	    
	@Autowired
	FacultyDAO fdao;
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.GET ) 
	public String studentHome(){
		return "/WEB-INF/pages/faculty/facultyHome.jsp";
	}
	
	@RequestMapping(value ="/addForm", method = RequestMethod.GET )
	public String addFacultyForm(){
		return "/WEB-INF/pages/faculty/addFaculty.jsp";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty){
		fdao.save(faculty);
		return "/WEB-INF/pages/faculty/viewFaculty.jsp";
	}
	
	@RequestMapping("/view")
	public String viewFacultys(){	
		return "/WEB-INF/pages/faculty/viewFaculty.jsp";
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public Faculty getFacultyInfo(@RequestParam("var") String var, @RequestParam("value") String value){
		Faculty faculty = (Faculty) fdao.get(var, value, Faculty.class);
		return faculty;
	}
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<Faculty> getAllFacultys(){
		List<Faculty> facultys = (List<Faculty>) fdao.getAll(Faculty.class);
		return facultys;
	}
	
	@RequestMapping("/editForm")
	public ModelAndView updateFaculty(@RequestParam("facultyId") String facultyId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/faculty/updateFaculty.jsp");
		mv.addObject("facultyId",facultyId);
		return mv;
	}

}
