package org.pc.controller;

import java.util.List;
import java.util.Map;

import org.pc.entity.Student;
import org.pc.service.IStudentMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentMgmtService service;
	
	@GetMapping("/welcome")
	public String showHome(@ModelAttribute("stud") Student stud) {
		return "home";
	}
	
	@PostMapping("/save")
	public String addStudent(@ModelAttribute("stud") Student stud,RedirectAttributes attr) {
		//use service
		String msg = service.insertStudent(stud);
		//add attribute 
		attr.addFlashAttribute("msg", msg);
		return "redirect:show";
	}
	
	@GetMapping("/show")
	public String showList(Map<String,Object> map) {
		//use service
		List<Student> list = service.getList();
		//add model data
		map.put("list",list);
		return "show_list";
	}
	
	@GetMapping("/denied")
	public String errorOccured() {
		return "access_denied";
	}
	
	
	//reference data using model data
	@ModelAttribute("rolesList")
	public List<String> roles(){
		return List.of("MANAGER","CLERK");
	}

}
