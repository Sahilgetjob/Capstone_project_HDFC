package com.hdfc.capstone.capstoneemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.capstone.capstoneemployee.entity.Employee;
import com.hdfc.capstone.capstoneemployee.repository.EmployeeRepository;
import com.hdfc.capstone.capstoneemployee.repository.EmployeeSpecification;

@Service
public class EmployeeService implements IEmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findWithEmployeeId(int employeeId) {
		Employee employee = employeeRepository.findOne(EmployeeSpecification.withEmployeeId(employeeId)).orElse(null);
		return employee;
	}
	
}
