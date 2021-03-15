package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entities.Employee;

public interface IEmployeeService {
	public Employee addEmployee(Employee emp);
	public void deleteEmployee(Integer eUserId);
	public Employee updateEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Integer eUserId);
	public List<Employee> getAllEmployeesByPagination(String maxPage, String ofset);
	public int getEmployeeCount();
	
}
