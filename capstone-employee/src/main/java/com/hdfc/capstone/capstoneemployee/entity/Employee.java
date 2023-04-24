package com.hdfc.capstone.capstoneemployee.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	//I have not used lombok because this project has only one entity class
	//Otherwise lombok would have been a good choice for creating getters and setter

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(nullable = false, length = 50, name = "employee_name")
	private String employeeName;
	
	@Column(nullable = false, name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	
	

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

	public LocalDate  getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	
}
