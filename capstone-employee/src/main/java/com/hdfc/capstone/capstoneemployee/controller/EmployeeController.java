package com.hdfc.capstone.capstoneemployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.capstoneemployee.dto.EmployeeDto;
import com.hdfc.capstone.capstoneemployee.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/{employeeId}")
	public EmployeeDto getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

}
