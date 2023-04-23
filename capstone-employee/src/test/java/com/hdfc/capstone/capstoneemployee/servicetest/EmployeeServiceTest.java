package com.hdfc.capstone.capstoneemployee.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
		 employee.setDateOfBirth("1990-04-22");
		 
		
		 
		when(employeeRepository.findById(2)).thenReturn(Optional.of(employee));
		
		Employee employeeExpected = employeeService.getEmployeeById(2);
		
		 assertEquals(1, employeeExpected.getEmployeeId());
		 assertEquals("John Doe", employeeExpected.getEmployeeName());
		 assertEquals("1990-04-22", employeeExpected.getDateOfBirth());
	}
	
}
