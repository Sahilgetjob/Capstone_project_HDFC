package com.hdfc.capstone.capstoneemployee.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hdfc.capstone.capstoneemployee.entity.Employee;

@Component
public class EmployeeMapper {

	private EmployeeMapper(){
		super();
	}

	public static EmployeeDto toDto(Employee employee) throws Exception{
		EmployeeDto employeeDto = new EmployeeDto();
		
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setDateOfBirth(employee.getDateOfBirth().toString());
		
		return employeeDto;
	}
	
	public static List<EmployeeDto> toListDto(List<Employee> employees) throws Exception{
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
		
		for(Employee employee : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setEmployeeName(employee.getEmployeeName());
			employeeDto.setDateOfBirth(employee.getDateOfBirth().toString());
			
			employeeDtos.add(employeeDto);
		}
		return employeeDtos;
	}
	
}
