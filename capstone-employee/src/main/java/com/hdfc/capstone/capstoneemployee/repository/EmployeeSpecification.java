package com.hdfc.capstone.capstoneemployee.repository;

import org.springframework.data.jpa.domain.Specification;

import com.hdfc.capstone.capstoneemployee.entity.Employee;


public interface EmployeeSpecification {
	
	//Creating Specification criteria for finding Employee with employeeId
	public static Specification<Employee> withEmployeeId(int employeeId){
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("employeeId"), employeeId);
	}
}
