package com.cg.ems.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ems.entities.Employee;
import com.cg.ems.repository.IEmployeeRepository;
import com.cg.ems.service.*;


@SpringBootTest
class EmployeeTestCase {

	Employee employee1;
	Employee employee2;
	Employee employee3;

	IEmployeeRepository employeeRepository;

	@Autowired
	EmployeeServiceImpl employeeService;

	@BeforeEach
	public void beforeEach() {
		employee1 = new Employee("san", "k", "2020-03-01", "saniya@gmail.com");
		employee2 = new Employee("saniya", "khan", "2020-03-01", "saniya@gmail.com");
		employee3 = new Employee("khan", "saniya", "2020-03-01", "saniya@gmail.com");

	}

	@Test
	void testAddEmployee() {

		when(employeeRepository.save(employee1)).thenReturn(employee1);
		Employee employee = employeeService.addEmployee(employee1);
		Assertions.assertEquals(employee, employee1);


	}


	@Test
	void testDeleteEmployee() {
		employeeService.deleteEmployee(1);
	}

	@Test
	void testUpdateEmployee() {
		Employee employee = new Employee("san", "k", "2020-03-01", "saniya@gmail.com");

		employeeService.updateEmployee(employee);
	}



	@Test
	void testGetAllEmployee() {
		employeeService.getAllEmployees();
	}

	

	@Test
	void testGetEmployeeByPagination() {
		employeeService.getAllEmployeesByPagination(null, null);
	}

	@Test
	void testGetEmployeeCount() {
		employeeService.getEmployeeCount();
	}

}
