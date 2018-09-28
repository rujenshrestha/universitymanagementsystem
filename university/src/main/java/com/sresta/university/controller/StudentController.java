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
		sdao.saveStudent(student);
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/view")
	public String viewStudents(){	
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<Student> getAllStudents(){
		List<Student> students = (List<Student>) sdao.getAllStudents();
		
		return students; //inbuilt spring library jackson converts into json format
	}
	
	@RequestMapping("/editForm")
	public ModelAndView updateStudent(@RequestParam("uId") String uId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/student/updateStudent.jsp");
		mv.addObject("uId",uId);
		return mv;
	}

	
	@RequestMapping("/get")  
	@ResponseBody
	public Student getStudent(@RequestParam("var") String var, @RequestParam("value") String value){
		Student student = (Student) sdao.getStudent(var, value);	
		return student; //inbuilt spring library jackson converts into json format  
	}
	
	@RequestMapping("/edit")
	public String saveUpdateStudent(@ModelAttribute("student") Student student){
		sdao.updateStudent(student);
		return "/WEB-INF/pages/student/viewStudent.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("uId") String uId){
		sdao.deleteStudent(uId);
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
	
}


