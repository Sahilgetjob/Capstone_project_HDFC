package com.hdfc.capstone.capstoneemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.capstone.capstoneemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
