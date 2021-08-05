package org.pc.service;

import java.util.List;

import org.pc.entity.Employee;
import org.pc.repository.IEmployeeRepo;
import org.pc.utility.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.apiclub.captcha.Captcha;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public String saveEmployee(Employee emp) {
		Employee employee = repo.save(emp);
		if(employee!=null)
			return "Employee Registered";
		else 
			return "Employee Not Registered";
	}

	@Override
	public List<Employee> getEmps() {
		List<Employee> list = repo.findAll();
		return list;
	}
	
	@Override
	public void setupCaptcha(Employee emp) {
		Captcha captcha = CaptchaUtil.createCaptcha(200, 80);
		emp.setAnswer(captcha.getAnswer());
		emp.setCaptcha("");
		emp.setImage(CaptchaUtil.convertImage(captcha));
	}


}
