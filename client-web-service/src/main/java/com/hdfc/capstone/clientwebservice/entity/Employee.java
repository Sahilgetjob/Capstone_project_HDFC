package com.hdfc.capstone.clientwebservice.entity;

import java.time.LocalDate;

//Adding Employee POJO class in client program to map EmployeeDto to Employee whenever necessary
public class Employee {



	private int employeeId;
	private String employeeName;
	private LocalDate dateOfBirth;
	

	//Getters & Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
