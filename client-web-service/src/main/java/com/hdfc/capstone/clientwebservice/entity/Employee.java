package com.hdfc.capstone.clientwebservice.entity;

public class Employee {



	private int employeeId;
	private String employeeName;
	private String dateOfBirth;
	
	//I have not used lombok because this project has only one entity class
	//Otherwise lombok would have been a good choice for creating getters and setter
	

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
