package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entities.Employee;
import com.cg.ems.service.IEmployeeService;

@RestController
@RequestMapping(value = "/ems")
public class EmsController {

	@Autowired
	private IEmployeeService employeeService;


	//add employee
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee tb = employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(tb, HttpStatus.OK);
	}

	//delete employee
	@DeleteMapping(value = "/delete/{eUserId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eUserId)
	{
		employeeService.deleteEmployee(eUserId);
		return new ResponseEntity<String>("Employee With ID :" + eUserId + " Deleted Successfully", HttpStatus.OK);
	}


	@PutMapping("/updateEmployee")
	@ResponseStatus(value = HttpStatus.OK)
	public String updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployee(emp);
		return "Employee Updated";
	}


	//get all employee
	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employees=employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}


	//get employee by id
	@GetMapping(value="/getEmployee/{eUserId}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable Integer eUserId)
	{
		Employee emp=employeeService.getEmployeeById(eUserId);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	
	//get employee by pagination
	@GetMapping("/getEmployeeByPagination")
	public ResponseEntity<List<Employee>> getAllEmployeesByPagination(@PathVariable String maxPage, String ofset){
		List<Employee> employees=employeeService.getAllEmployeesByPagination(ofset, ofset);
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	

	//get employee by count
	@GetMapping(value="/getEmployeeCount")
	public ResponseEntity<String> getEmployeeCount()
	{
		int count = employeeService.getEmployeeCount();
		return new ResponseEntity<String>("The number of employees are " + count, HttpStatus.OK);
	}


}