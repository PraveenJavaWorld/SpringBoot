package org.pc.controller;

import java.util.Map;

import org.pc.entity.Employee;
import org.pc.service.IEmployeeService;
import org.pc.utility.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	
	
	@GetMapping("/welcome")
	public String showHome(Model model) {
		Employee emp = new Employee();
		service.setupCaptcha(emp);
		model.addAttribute("emp",emp);
		return "home";
	}
	
	@PostMapping("/save")
	public String saveEmp(Map<String,Object> map,@ModelAttribute("emp") Employee emp) {
		if(emp.getCaptcha().equals(emp.getAnswer())) {
			//use service
			String message = service.saveEmployee(emp);
			//add model data
			map.put("message", message);
			//return lvn
			return "home";
		}
		else {
			service.setupCaptcha(emp);
			return "home";
		}
		
	}

}
