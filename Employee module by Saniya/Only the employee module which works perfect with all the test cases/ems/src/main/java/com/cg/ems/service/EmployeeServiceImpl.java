package com.cg.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.entities.Employee;
import com.cg.ems.repository.IEmployeeRepository;
import com.cg.ems.exception.DeletionException;
import com.cg.ems.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService  {

	@Autowired
	private IEmployeeRepository employeeRepository;

	//add employee 
	@Override
	public Employee addEmployee(Employee emp) {

		employeeRepository.save(emp);
		return emp;
	}

	//delete employee
	@Override
	public void deleteEmployee(Integer eUserId){
		Optional<Employee> employee = employeeRepository.findById(eUserId);
		if(employee.isPresent()) {
			Employee e = employee.get();
			employeeRepository.delete(e);
		}
		else {
			throw new DeletionException("Customer with id " +eUserId +" doesn't exist");

		}
	}

	//update employee
	@Override
	public Employee updateEmployee(Employee emp) {

		if(emp != null)	{
			Employee existingEmployee = getEmployeeById(emp.geteUserId());
			existingEmployee.setFirstName(emp.getFirstName());
			existingEmployee.setLastName(emp.getLastName());
			existingEmployee.setDob(emp.getDob());
			existingEmployee.setEmail(emp.getEmail());

			return existingEmployee;
		}
		else {
			throw new EmployeeNotFoundException("Customer with id " + emp.geteUserId() +" doesn't exist");
		}
	}

	//get all employee
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=employeeRepository.findAll();
		return employees;
	}


	//get employee by id
	@Override
	public Employee getEmployeeById(Integer eUserId) {
		Optional<Employee> employee=employeeRepository.findById(eUserId);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new EmployeeNotFoundException("Customer with id " +eUserId +" doesn't exist");
		}
	}



	//get employee by pagination
	@Override
	public List<Employee> getAllEmployeesByPagination(String maxPage, String ofset) {
		return null;

	}


	//get employee count
	@Override
	public int getEmployeeCount() {
		int count = (int) employeeRepository.count();
		return count;	
	}


}