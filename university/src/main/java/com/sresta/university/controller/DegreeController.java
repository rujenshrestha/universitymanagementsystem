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
	public String addDegreeForm(){
		return "/WEB-INF/pages/degree/addDegree.jsp";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String saveDegree(@ModelAttribute("degree") Degree degree){
		ddao.save(degree);
		return "/WEB-INF/pages/degree/viewDegree.jsp";
	}
	
	@RequestMapping("/view")
	public String viewDegree(@RequestParam("var") String var, @RequestParam("value") String value){	
		return "/WEB-INF/pages/degree/viewDegree.jsp?var="+var+"&value"+value;
	}
	
	@RequestMapping("/get")  
	@ResponseBody
	public HashMap getDegreeInfo(@RequestParam("var") String var, @RequestParam("value") String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Degree degree = (Degree) ddao.get(var, value, Degree.class);
		HashMap result = new HashMap();
		if(degree != null){
			result.put("degId", degree.getDegId());
			result.put("degName", degree.getDegName());
			result.put("level",degree.getLevel());
			if(degree.getLevel().equals("G")){
				result.put("levelDesc","Graduate");
			}else if(degree.getLevel().equals("U")){
				result.put("levelDesc","Undergraduate");
			}
			result.put("deptId", degree.getDeptId());
			result.put("deptName", ddao.getName("Department","deptName","deptId", degree.getDeptId()));
		}
		return result;
	}
	
	@RequestMapping("/getBy")  
	@ResponseBody
	public List<HashMap> getFileteredRows(@RequestParam("var") String var, @RequestParam("value") String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Degree> degrees = (List<Degree>) ddao.getByField(var, value, Degree.class);
		HashMap result;
		List<HashMap> list = new ArrayList<HashMap>();
		for(Degree deg : degrees){
	
			result = new HashMap();
			result.put("degId", deg.getDegId());
			result.put("degName", deg.getDegName());
			if(deg.getLevel().equals("G")){
				result.put("level","Graduate");
			}else if(deg.getLevel().equals("U")){
				result.put("level","Undergraduate");
			}
			result.put("deptId", deg.getDeptId());
			result.put("deptName", ddao.getName("Department","deptName","deptId", deg.getDeptId()));
			list.add(result);
		}
		
		return list;
	}
	
	
	
	@RequestMapping("/getAll")  
	@ResponseBody
	public List<HashMap> getAllDegrees() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Degree> degrees = (List<Degree>) ddao.getAll(Degree.class);
		HashMap result;
		List<HashMap> list = new ArrayList<HashMap>();
		for(Degree deg : degrees){
			result = new HashMap();
			result.put("degId", deg.getDegId());
			result.put("degName", deg.getDegName());
			if(deg.getLevel().equals("G")){
				result.put("level","Graduate");
			}else if(deg.getLevel().equals("U")){
				result.put("level","Undergraduate");
			}
			result.put("deptId", deg.getDeptId());
			result.put("deptName", ddao.getName("Department","deptName","deptId", deg.getDeptId()));
			list.add(result);
		}
		return list;
	}
	
	
	@RequestMapping("/editForm")
	public ModelAndView updateDegree(@RequestParam("degId") String degId){
		ModelAndView mv = new ModelAndView("/WEB-INF/pages/degree/updateDegree.jsp");
		mv.addObject("degId",degId);
		return mv;
	}
	
	@RequestMapping("/edit")
	public String saveUpdateDegree(@ModelAttribute("degree") Degree degree) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		ddao.update(degree, "degId", degree.getDegId());
		return "/WEB-INF/pages/degree/viewDegree.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteDegree(@RequestParam("degId") String degId){
		ddao.delete("degId", degId);
		return "/WEB-INF/pages/degree/viewDegree.jsp";
	}
	
	@RequestMapping("/searchForm")
	public String searchDegrees(){	
		return "/WEB-INF/pages/degree/searchDegree.jsp";  
	}
	
	@RequestMapping(value = "/suggest", method = RequestMethod.GET)
	public @ResponseBody List<String> suggestDegreeName(@RequestParam("name") String degreeName){
		List<String> degreeList =  ddao.getDegreeByName(degreeName);
		return degreeList;
	}
	

}
