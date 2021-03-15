package com.cg.ems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ems.entities.Employee;
import com.cg.ems.service.EmployeeServiceImpl;

@SpringBootTest
class EmployeeTestCase {

	//Employee e = new Employee();
	
	Employee employee;
	
	@Autowired
	EmployeeServiceImpl employeeService;

	//Employee employee1 = new Employee(1, "san", "k", "2020-03-01", "saniya@gmail.com");

	@BeforeEach
	public void beforeEach() {
		Employee employee1 = new Employee(1, "san", "k", "2020-03-01", "saniya@gmail.com");
		Employee employee2 = new Employee(2, "s", "k", "2020-03-01", "saniya@gmail.com");
		Employee employee3 = new Employee(3, "sn", "k", "2020-03-01", "saniya@gmail.com");

		
	}
	
	@Test
	void testAddEmployee() {
		Employee employee = new Employee(1, "san", "k", "2020-03-01", "saniya@gmail.com");
		//Employee e2 = new Employee(2, "san", "k", "2020-03-01", "saniya@gmail.com");

		employeeService.addEmployee(employee);
		//employeeService.addEmployee(e2);
		

	}
	
	@Test
	void testDeleteEmployee() {
		//Employee employee = new Employee(2, "san", "k", "2020-03-01", "saniya@gmail.com");

		employeeService.deleteEmployee(1);
	}
	
	@Test
	void testUpdateEmployee() {
		Employee employee = new Employee(1, "saa", "khaaa", "2020-03-01", "saniya@gmail.com");

		employeeService.updateEmployee(employee);
	}
	
	
	
	@Test
	void testGetAllEmployee() {
		employeeService.getAllEmployees();
	}
	
	@Test
	void testGetEmployeeById() {
		employeeService.getEmployeeById(1);
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
