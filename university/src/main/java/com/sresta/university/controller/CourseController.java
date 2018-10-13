package com.sresta.university.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
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
	public String courseHome(){
		return "/WEB-INF/pages/course/courseHome.jsp";
	}
	
	@RequestMapping(value ="/addForm", method = RequestMethod.GET )
	public String addCourseForm(){
		return "/WEB-INF/pages/course/addCourse.jsp";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("department") Course department){
		cdao.save(department);
		return "/WEB-INF/pages/course/viewCourse.jsp?var=&value=";
	}
	
	@RequestMapping("/view")
	public String viewCourse(@RequestParam("var") String var, @RequestParam("value") String value){		
		return "/WEB-INF/pages/course/viewCourse.jsp?var="+var+"&value="+value;
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public HashMap getCourseInfo(@RequestParam("var") String var, @RequestParam("value") String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Course course = (Course) cdao.get(var, value, Course.class);
		HashMap result = new HashMap();
		if(course != null){
			result.put("crseId", course.getCrseId());
			result.put("crseName", course.getCrseName());
			result.put("level",course.getLevel());
			if(course.getLevel().equals("G")){
				result.put("levelDesc","Graduate");
			}else if(course.getLevel().equals("U")){
				result.put("levelDesc","Undergraduate");
			}
			result.put("degId", course.getDegId());
			result.put("degName", cdao.getName("Degree","degName","degId", course.getDegId()));
			result.put("deptId", course.getDeptId());
			result.put("deptName", cdao.getName("Department","deptName","deptId", course.getDeptId()));
		}
		return result;
	}
	
	
	@RequestMapping("/getBy")  
	@ResponseBody
	public List<HashMap> getFileteredRows(@RequestParam("var") String var, @RequestParam("value") String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Course> courses = (List<Course>) cdao.getByField(var, value, Course.class);
		HashMap result;
		List<HashMap> list = new ArrayList<HashMap>();
		for(Course crse : courses){
	
			result = new HashMap();
			result.put("crseId", crse.getCrseId());
			result.put("crseName", crse.getCrseName());
			result.put("level", crse.getLevel());
			if(crse.getLevel().equals("G")){
				result.put("levelDesc","Graduate");
			}else if(crse.getLevel().equals("U")){
				result.put("levelDesc","Undergraduate");
			}
			result.put("deptId", crse.getDeptId());
			result.put("deptName", cdao.getName("Department","deptName","deptId", crse.getDeptId()));
			result.put("degId", crse.getDegId());
			result.put("degName", cdao.getName("Degree","degName","degId", crse.getDegId()));
			list.add(result);
		}
		
		return list;
	}

	@RequestMapping("/getAll")  
	@ResponseBody
	public List<HashMap> getAllCourses() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Course> courses = (List<Course>) cdao.getAll(Course.class);
		HashMap result;
		List<HashMap> list = new ArrayList<HashMap>();
		for(Course crse : courses){
			result = new HashMap();
			result.put("crseId", crse.getCrseId());
			result.put("crseName", crse.getCrseName());
			result.put("level", crse.getLevel());
			if(crse.getLevel().equals("G")){
				result.put("levelDesc","Graduate");
			}else if(crse.getLevel().equals("U")){
				result.put("levelDesc","Undergraduate");
			}
			result.put("deptId", crse.getDeptId());
			result.put("deptName", cdao.getName("Department","deptName","deptId", crse.getDeptId()));
			result.put("degId", crse.getDegId());
			result.put("degName", cdao.getName("Degree","degName","degId", crse.getDegId()));
			list.add(result);
		}
		return list;
	}
	
	@RequestMapping("/editForm")
	public ModelAndView updateCourse(@RequestParam("crseId") String crseId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/course/updateCourse.jsp");
		mv.addObject("crseId",crseId);
		return mv;
	}
	
	@RequestMapping("/delete")
	public String deleteCourse(@RequestParam("crseId") String crseId){
		cdao.delete("crseId", crseId);
		return "/WEB-INF/pages/course/viewCourse.jsp?var=&value=";
	}
	
	@RequestMapping("/searchForm")
	public String searchCourses(){	
		return "/WEB-INF/pages/course/searchCourse.jsp";  
	}
	
	@RequestMapping(value = "/suggest", method = RequestMethod.GET)
	public @ResponseBody List<String> suggestCourseName(@RequestParam("name") String courseName){
		List<String> courseList =  cdao.getEntityByName("crseName", courseName);
		return courseList;
	}

}
