package org.pc.controller;

import java.util.List;
import java.util.Map;

import org.pc.entity.Customer;
import org.pc.service.ICustomeMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@Autowired
	private ICustomeMgmtService service;
	
	@GetMapping("/welcome")
	public String showHome(@ModelAttribute("cust") Customer cust) {
		return "CreateUser";
	}
	
	@PostMapping("/save")
	public String page(@ModelAttribute("cust") Customer cust,Map<String,Object> map) {
		//use service
		String msg = service.insertCustomer(cust);
		map.put("msg", msg);
		return "resultpage";
	}
	
	@GetMapping("/list")
	public String showCustomers(Map<String,Object> map) {
		//use service
		List<Customer> list = service.customerList();
		map.put("list", list);
		return "show_list";
	}
	

}
