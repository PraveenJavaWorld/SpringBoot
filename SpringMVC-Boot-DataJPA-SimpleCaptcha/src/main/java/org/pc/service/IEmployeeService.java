package org.pc.service;

import java.util.List;

import org.pc.entity.Employee;

public interface IEmployeeService {
	
	public String saveEmployee(Employee emp);
	public List<Employee> getEmps();
	public void setupCaptcha(Employee emp);

}
