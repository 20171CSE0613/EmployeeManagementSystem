package com.cg.ems.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.entities.Employee;
import com.cg.ems.exception.DeletionException;
import com.cg.ems.exception.EmployeeNotFoundException;
import com.cg.ems.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService  {

	private final static Logger log = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private IEmployeeRepository employeeRepository;


	@Override
	public Employee addEmployee(Employee employee) {

		Employee employee1 = employeeRepository.save(employee);
		return employee1;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) {
			log.error("EmployeeNotFoundException");
			throw new EmployeeNotFoundException("Employee with ID "+employeeId+" not found.");
		}
		Employee emp = employee.get();
		return emp;
	}





	//get employee count
	@Override
	public int getEmployeeCount() {
		int count = (int) employeeRepository.count();
		return count;	
	}

	//get employee by pagination
	@Override
	public List<Employee> getAllEmployeesByPagination(String maxPage, String ofset) {
		return null;

	}


	//get all employee
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=employeeRepository.findAll();
		return employees;
	}


	//update employee
	@Override
	public Employee updateEmployee(Employee emp) {

		if(emp != null)	{
			Employee existingEmployee = getEmployeeById(emp.getUserId());
			existingEmployee.setFirstName(emp.getFirstName());
			existingEmployee.setLastName(emp.getLastName());
			existingEmployee.setDob(emp.getDob());
			existingEmployee.setEmail(emp.getEmail());

			return existingEmployee;
		}
		else {
			throw new EmployeeNotFoundException("Customer with id " + emp.getUserId() +" doesn't exist");
		}
	}

	//delete employee
	@Override
	public void deleteEmployee(Integer userId){
		Optional<Employee> employee = employeeRepository.findById(userId);
		if(employee.isPresent()) {
			Employee e = employee.get();
			employeeRepository.delete(e);
		}
		else {
			throw new DeletionException("Customer with id " +userId +" doesn't exist");

		}
	}












}
