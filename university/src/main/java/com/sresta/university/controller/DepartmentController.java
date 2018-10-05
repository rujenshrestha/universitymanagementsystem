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

import com.sresta.university.dao.DepartmentDAO;
import com.sresta.university.entity.Department;

@Controller
@RequestMapping("department")
public class DepartmentController {
	    
	@Autowired
	DepartmentDAO ddao;
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.GET ) 
	public String studentHome(){
		return "/WEB-INF/pages/department/departmentHome.jsp";
	}
	
	@RequestMapping(value ="/addForm", method = RequestMethod.GET )
	public String addStudentForm(){
		return "/WEB-INF/pages/department/addDepartment.jsp";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("department") Department department){
		ddao.save(department);
		return "/WEB-INF/pages/department/viewDepartment.jsp";
	}
	
	@RequestMapping("/view")
	public String viewStudents(){	
		return "/WEB-INF/pages/department/viewDepartment.jsp";
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public Department getDepartmentInfo(@RequestParam("var") String var, @RequestParam("value") String value){
		Department department = (Department) ddao.get(var, value, Department.class);
		return department;
	}
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<Department> getAllStudents(){
		List<Department> departments = (List<Department>) ddao.getAll(Department.class);
		return departments;
	}
	
	@RequestMapping("/editForm")
	public ModelAndView updateStudent(@RequestParam("deptId") String deptId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/department/updateDepartment.jsp");
		mv.addObject("deptId",deptId);
		return mv;
	}

}
