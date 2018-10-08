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

import com.sresta.university.dao.CourseDAO;
import com.sresta.university.entity.Course;


@Controller
@RequestMapping("course")
public class CourseController {
	    
	@Autowired
	CourseDAO cdao;
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.GET ) 
	public String studentHome(){
		return "/WEB-INF/pages/course/courseHome.jsp";
	}
	
	@RequestMapping(value ="/addForm", method = RequestMethod.GET )
	public String addStudentForm(){
		return "/WEB-INF/pages/course/addCourse.jsp";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("department") Course department){
		cdao.save(department);
		return "/WEB-INF/pages/course/viewDepartment.jsp";
	}
	
	@RequestMapping("/view")
	public String viewCourse(){	
		return "/WEB-INF/pages/course/viewCourse.jsp";
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public Course getCourseInfo(@RequestParam("var") String var, @RequestParam("value") String value){
		Course course = (Course) cdao.get(var, value, Course.class);
		return course;
	}
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<Course> getAllStudents(){
		List<Course> departments = (List<Course>) cdao.getAll(Course.class);
		return departments;
	}
	
	@RequestMapping("/editForm")
	public ModelAndView updateCourse(@RequestParam("crseId") String crseId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/course/updateCourse.jsp");
		mv.addObject("crseId",crseId);
		return mv;
	}

}
