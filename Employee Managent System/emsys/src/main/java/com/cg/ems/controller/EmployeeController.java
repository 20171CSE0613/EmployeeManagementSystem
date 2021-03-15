package com.cg.ems.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entities.Employee;
import com.cg.ems.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/ems/employee")
@Api(description = "Controller of Employee Module")

public class EmployeeController {

	public static final Logger Log = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;


	//add employee
	@ApiOperation(value = "addEmployee controller method")
	@PostMapping(value = "/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {

		Log.info(" Employee Controller Triggerd");

		Employee employee = employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	//get employee by id
	@ApiOperation(value = "getEmployeeById controller method")
	@GetMapping(value = "/getEmployeeById/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId) {

		Log.info(" Employee Controller Triggerd");

		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}








	//get all employee
	@ApiOperation(value = "getAllEmployee controller method")
	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		Log.info(" Employee Controller Triggerd");
		List<Employee> employees=employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}


	//get employee by pagination
	@ApiOperation(value = "getEmployeeByPagination controller method")
	@GetMapping("/getEmployeeByPagination/{maxPage}/{ofset}")
	public ResponseEntity<List<Employee>> getAllEmployeesByPagination(@PathVariable String maxPage,@PathVariable String ofset)
	{
		Log.info(" Employee Controller Triggerd");
		List<Employee> employees=employeeService.getAllEmployeesByPagination(maxPage, ofset);
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}



	/*//get employee by count
		@GetMapping(value="/getEmployeeCount")
		public ResponseEntity<String> getEmployeeCount()
		{
			int count = employeeService.getEmployeeCount();
			return new ResponseEntity<String>("The number of employees are " + count, HttpStatus.OK);
		}
	 */

	//get employee by count
	@ApiOperation(value = "getEmployeeCount controller method")
	@GetMapping(value="/getEmployeeCount")
	public ResponseEntity<String> getEmployeeCount()
	{
		Log.info(" Employee Controller Triggerd");
		int count = employeeService.getEmployeeCount();
		return new ResponseEntity<String>("The number of employees are " + count, HttpStatus.OK);
	}



	//delete employee
	@ApiOperation(value = "deleteEmployee controller method")
	@DeleteMapping(value = "/delete/{userId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int userId)
	{
		Log.info(" Employee Controller Triggerd");
		employeeService.deleteEmployee(userId);
		return new ResponseEntity<String>("Employee With ID :" + userId + " Deleted Successfully", HttpStatus.OK);
	}


	//update employee
	@ApiOperation(value = "updateEmployee controller method")
	@PutMapping("/updateEmployee")
	@Transactional

	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) 
	{
		Log.info(" Employee Controller Triggerd");
		employeeService.updateEmployee(emp);
		return new ResponseEntity<>("Employee With ID :" + emp.getUserId() + " Updated Successfully", HttpStatus.ACCEPTED);
	}

}
