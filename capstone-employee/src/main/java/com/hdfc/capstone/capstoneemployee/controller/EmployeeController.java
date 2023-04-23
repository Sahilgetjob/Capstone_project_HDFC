package com.hdfc.capstone.capstoneemployee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.capstoneemployee.dto.EmployeeDto;
import com.hdfc.capstone.capstoneemployee.dto.EmployeeMapper;
import com.hdfc.capstone.capstoneemployee.entity.Employee;
import com.hdfc.capstone.capstoneemployee.exceptionhandler.InvalidEmployeeIDException;
import com.hdfc.capstone.capstoneemployee.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int employeeId) throws Exception {
		logger.info("Getting employee details for employee id {}", employeeId );
		Employee employee = employeeService.getEmployeeById(employeeId);
		if(employee == null) {
			String errorMessage = "Employee details not found for employee id "+ employeeId;
			logger.warn(errorMessage);
			throw new InvalidEmployeeIDException(errorMessage);
		}
		EmployeeDto employeeDto = EmployeeMapper.toDto(employee);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
		
		
	}

}
