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
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	
	@Test
	void EmployeeServiceFindwithEmployeeIdTest() throws Exception {
		Employee employee = new Employee();
		int employeeId = 2;
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName("Mark Hamill");
		employee.setDateOfBirth(LocalDate.of(1986, 11, 12));
		
		
		
		when(employeeRepository.findOne(ArgumentMatchers.<Specification<Employee>>any()))
			.thenReturn(Optional.of (employee));
		
		Employee employeeExpected = employeeService.findWithEmployeeId(employeeId);
		assertEquals(2, employeeExpected.getEmployeeId());
		assertEquals("Mark Hamill", employeeExpected.getEmployeeName());
		assertEquals(LocalDate.of(1986, 11, 12), employeeExpected.getDateOfBirth());
	}
	
}
