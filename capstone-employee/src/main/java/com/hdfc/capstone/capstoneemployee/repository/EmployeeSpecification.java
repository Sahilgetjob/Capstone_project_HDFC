package com.hdfc.capstone.capstoneemployee.repository;

import org.springframework.data.jpa.domain.Specification;

import com.hdfc.capstone.capstoneemployee.entity.Employee;


public interface EmployeeSpecification {

	public static Specification<Employee> withEmployeeId(int employeeId){
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("employeeId"), employeeId);
	}
}
