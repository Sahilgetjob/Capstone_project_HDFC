package com.hdfc.capstone.capstoneemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.capstone.capstoneemployee.entity.Employee;
import com.hdfc.capstone.capstoneemployee.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(int employeeId) {
		
		return employeeRepository.findById(employeeId).orElse(null);
	}

}
