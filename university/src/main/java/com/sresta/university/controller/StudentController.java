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

import com.sresta.university.dao.StudentDAO;
import com.sresta.university.entity.Student;


@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentDAO sdao;
	
	Student std;
	@RequestMapping(value ={"/",""}, method = RequestMethod.GET )
	public String studentHome(){
		return "/WEB-INF/pages/student/studentHome.jsp";
	}
	
	@RequestMapping(value ="/addForm", method = RequestMethod.GET )
	public String addStudentForm(){
		return "/WEB-INF/pages/student/addStudent.jsp";
	}
	

	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student){
		sdao.save(student);
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/view")
	public String viewStudents(){	
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/courseForm")
	public String manageCourses(){	
		return "/WEB-INF/pages/student/manageCourse.jsp";
	}
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<HashMap> getAllStudents() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		String[] fields = {"uId","firstName","middleName","lastName","level","degId"};
		List<Student> students = (List<Student>) sdao.getAll(Student.class);
		HashMap result;
		List<HashMap> list = new ArrayList<HashMap>();
		for(Student std : students){
	
			result = new HashMap();
			result.put("uId", std.getuId());
			result.put("firstName", std.getFirstName());
			result.put("lastName", std.getLastName());
			if(std.getMiddleName() == null){
				result.put("middleName"," ");
			}else{
				result.put("middleName"," "+std.getMiddleName()+" ");
			}
			result.put("level", std.getLevel());
			result.put("degId", std.getDegId());
			result.put("degName", sdao.getName("Degree", "degName", "degId", std.getDegId()));
			list.add(result);
		}
		return list;
	}
	
	
	
	@RequestMapping("/editForm")
	public ModelAndView updateStudent(@RequestParam("uId") String uId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/student/updateStudent.jsp");
		mv.addObject("uId",uId);
		return mv;
	}

	
	/*@RequestMapping("/get")  
	@ResponseBody
	public Student getStudent(@RequestParam("var") String var, @RequestParam("value") String value){
		Student student = (Student) sdao.get(var, value, Student.class);
		return student; //inbuilt spring library jackson converts into json format  
	}*/
	
	@RequestMapping("/get")  
	@ResponseBody
	public HashMap getCourseInfo(@RequestParam("var") String var, @RequestParam("value") String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Student student = (Student) sdao.get(var, value, Student.class);
		HashMap result = new HashMap();
		if(student != null){
			result.put("uId", student.getuId());
			result.put("firstName", student.getFirstName());
			result.put("middleName",student.getMiddleName());
			result.put("lastName",student.getLastName());
			result.put("gender",student.getGender());
			if(student.getGender().equals("M")){
				result.put("genderDesc","Male");
			}else if(student.getGender().equals("F")){
				result.put("genderDesc","Female");
			}else if(student.getGender().equals("U")){
				result.put("genderDesc","I do not wish to disclose");
			}
			result.put("level", student.getLevel());
			if(student.getLevel().equals("G")){
				result.put("levelDesc","Graduate");
			}else if(student.getLevel().equals("U")){
				result.put("levelDesc","Undergraduate");
			}
			result.put("degId", student.getDegId());
			result.put("degName", sdao.getName("Degree","degName","degId", student.getDegId()));
			result.put("deptId", student.getDeptId());
			result.put("deptName", sdao.getName("Department","deptName","deptId", student.getDeptId()));
		}
		return result;
	}
	
	@RequestMapping("/edit")
	public String saveUpdateStudent(@ModelAttribute("student") Student student) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		sdao.update(student, "uId", student.getuId());
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("uId") String uId){
		sdao.delete("uId", uId);
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/searchForm")
	public String searchStudents(){	
		return "/WEB-INF/pages/student/searchStudent.jsp";  
	}
	
	@RequestMapping(value = "/suggest", method = RequestMethod.GET)
	public @ResponseBody List<String> suggestStudentName(@RequestParam("name") String studentName){
		List<String> studentList =  sdao.getStudentByName(studentName);
		return studentList;
	}
	
	@RequestMapping("/courses")  
	@ResponseBody
	public List<Student> getStudentCourses(){
		List<Student> students = (List<Student>) sdao.getAll(Student.class);
		
		return students; //inbuilt spring library jackson converts into json format
	}
	
	
}


