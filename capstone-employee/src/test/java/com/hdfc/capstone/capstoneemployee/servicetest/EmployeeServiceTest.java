package com.hdfc.capstone.capstoneemployee.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.capstone.capstoneemployee.entity.Employee;
import com.hdfc.capstone.capstoneemployee.repository.EmployeeRepository;
import com.hdfc.capstone.capstoneemployee.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	void EmployeeServiceGetByEmployeeIDTest() throws Exception {
		Employee employee = new Employee();
		 employee.setEmployeeId(1);
		 employee.setEmployeeName("John Doe");
		 employee.setDateOfBirth(LocalDate.of(1990, 01, 01));
		 
		
		 
		when(employeeRepository.findById(2)).thenReturn(Optional.of(employee));
		
		Employee employeeExpected = employeeService.getEmployeeById(2);
		
		 assertEquals(1, employeeExpected.getEmployeeId());
		 assertEquals("John Doe", employeeExpected.getEmployeeName());
		 assertEquals(LocalDate.of(1990, 01, 01), employeeExpected.getDateOfBirth());
	}
	
}
