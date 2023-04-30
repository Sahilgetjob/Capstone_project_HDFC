package com.hdfc.capstone.capstoneemployee.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.hdfc.capstone.capstoneemployee.entity.Employee;
import com.hdfc.capstone.capstoneemployee.repository.EmployeeRepository;
import com.hdfc.capstone.capstoneemployee.service.EmployeeService;

@SpringBootTest
class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	
	@Test
	void EmployeeServiceFindwithEmployeeIdTest() throws Exception {
		
		// Creating mock Employee object
		Employee employee = new Employee();
		int employeeId = 2;
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName("Mark Hamill");
		employee.setDateOfBirth(LocalDate.of(1986, 11, 12));
		
		
		// Setting up the mock behavior for the findOne method of the mock repository
		when(employeeRepository.findOne(ArgumentMatchers.<Specification<Employee>>any()))
			.thenReturn(Optional.of (employee));
		
		// Calling the findWithEmployeeId method of the service class
		Employee SearchResult = employeeService.findWithEmployeeId(employeeId);
		
		//Asserting the results
		assertEquals(2, SearchResult.getEmployeeId());
		assertEquals("Mark Hamill", SearchResult.getEmployeeName());
		assertEquals(LocalDate.of(1986, 11, 12), SearchResult.getDateOfBirth());
	}
	
}
