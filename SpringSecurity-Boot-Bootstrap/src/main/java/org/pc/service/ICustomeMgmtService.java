package org.pc.service;

import java.util.List;

import org.pc.entity.Customer;

public interface ICustomeMgmtService {
	
	public String insertCustomer(Customer cust);
	public List<Customer> customerList();

}
