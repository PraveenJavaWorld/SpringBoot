package org.pc.service;

import java.util.ArrayList;
import java.util.List;

import org.pc.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomeMgmtServiceImpl implements ICustomeMgmtService {
	
	List<Customer> customerList = new ArrayList<>();

	@Override
	public String insertCustomer(Customer cust) {
		cust.getAccno();
		cust.getCardno();
		cust.getMobile();
		cust.getCid();
		customerList.add(cust);
		return "Customer Added Successfully";
	}
	
	@Override
	public List<Customer> customerList() {
		return customerList;
	}

}
