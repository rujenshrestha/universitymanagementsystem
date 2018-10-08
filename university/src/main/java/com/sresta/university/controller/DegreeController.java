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

import com.sresta.university.dao.DegreeDAO;
import com.sresta.university.entity.Degree;

@Controller
@RequestMapping("degree")
public class DegreeController {
	    
	@Autowired
	DegreeDAO ddao;
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.GET ) 
	public String degreeHome(){
		return "/WEB-INF/pages/degree/degreeHome.jsp";
	}
	
	@RequestMapping(value ="/addForm", method = RequestMethod.GET )
	public String addStudentForm(){
		return "/WEB-INF/pages/degree/addDegree.jsp";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveDegree(@ModelAttribute("degree") Degree degree){
		ddao.save(degree);
		return "/WEB-INF/pages/degree/viewDegree.jsp";
	}
	
	@RequestMapping("/view")
	public String viewDegree(){	
		return "/WEB-INF/pages/degree/viewDegree.jsp";
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public Degree getDegreeInfo(@RequestParam("var") String var, @RequestParam("value") String value){
		Degree degree = (Degree) ddao.get(var, value, Degree.class);
		return degree;
	}
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<Degree> getAllDegrees(){
		List<Degree> degrees = (List<Degree>) ddao.getAll(Degree.class);
		return degrees;
	}
	
	@RequestMapping("/editForm")
	public ModelAndView updateDegree(@RequestParam("degId") String degId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/degree/updateDegree.jsp");
		mv.addObject("degId",degId);
		return mv;
	}

}
