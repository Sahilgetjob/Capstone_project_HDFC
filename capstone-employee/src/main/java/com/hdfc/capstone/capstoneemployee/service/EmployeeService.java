package com.hdfc.capstone.capstoneemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.capstone.capstoneemployee.dto.EmployeeDto;
import com.hdfc.capstone.capstoneemployee.dto.EmployeeMapper;
import com.hdfc.capstone.capstoneemployee.entity.Employee;
import com.hdfc.capstone.capstoneemployee.exceptionhandler.InvalidEmployeeIDException;
import com.hdfc.capstone.capstoneemployee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeDto getEmployeeById(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
											  .orElseThrow(() -> new InvalidEmployeeIDException("Employee ID is Invalid, Please enter valid employee ID"));
		return EmployeeMapper.toDto(employee);
	}

}
