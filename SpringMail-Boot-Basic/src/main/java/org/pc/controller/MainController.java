package org.pc.controller;

import java.util.Map;

import org.pc.model.MailModel;
import org.pc.service.IMailMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@Autowired
	private IMailMgmtService service;
	
	@GetMapping("/welcome")
	public String showHome(@ModelAttribute("model") MailModel model) {
		return "home";
	}
	
	@PostMapping("/send")
	public String sendMail(Map<String,Object> map,@ModelAttribute("model") MailModel model,@RequestParam MultipartFile file) {
		try {
			//use service
			String msg = service.sendMail(model,file);
			//set model attribute
			map.put("msg", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}

}
