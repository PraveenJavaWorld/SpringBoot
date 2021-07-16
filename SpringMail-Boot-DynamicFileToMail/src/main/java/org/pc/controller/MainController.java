package org.pc.controller;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.pc.model.MailModel;
import org.pc.service.IMailMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@Autowired
	private IMailMgmtService service;
	
	@GetMapping("/welcome")
	public String showHome(@ModelAttribute("model") MailModel model) {
		return "home";
	}
	
	@PostMapping("/send")
	public String sendMail(Map<String,Object> map,@ModelAttribute("model") MailModel model) {
		try {
			//use service
			String msg = service.sendMail(model);
			//set model attribute
			map.put("msg", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}

}
