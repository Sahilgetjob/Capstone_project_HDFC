package com.hdfc.capstone.capstoneemployee.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")

@Getter
@Setter
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(nullable = false, length = 50, name = "employee_name")
	private String employeeName;
	
	@Column(nullable = false, name = "date_of_birth")
	private LocalDate dateOfBirth;

	
}
