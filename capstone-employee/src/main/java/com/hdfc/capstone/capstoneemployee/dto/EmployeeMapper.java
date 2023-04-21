package com.hdfc.capstone.capstoneemployee.dto;

import org.springframework.stereotype.Component;

import com.hdfc.capstone.capstoneemployee.entity.Employee;

@Component
public class EmployeeMapper {

	public static EmployeeDto toDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setDateOfBirth(employee.getDateOfBirth());
		
		return employeeDto;
	}
	
	public static Employee toEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setDateOfBirth(employeeDto.getDateOfBirth());
		
		return employee;
	}
}