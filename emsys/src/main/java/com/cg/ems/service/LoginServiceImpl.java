package com.cg.ems.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.entities.Employee;
import com.cg.ems.entities.UserDetails;
import com.cg.ems.exception.EmployeeNotFoundException;
import com.cg.ems.exception.InvalidUserIdException;
import com.cg.ems.exception.PasswordIncorrectException;
import com.cg.ems.exception.RoleNotFoundException;
import com.cg.ems.repository.IEmployeeRepository;
import com.cg.ems.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	private final static Logger log = LogManager.getLogger(LoginServiceImpl.class);

	@Autowired
	private ILoginRepository loginRepository;

	@Autowired
	private IEmployeeRepository employeeRepository;
		
	
	// used to validate the user 
	@Override
	public UserDetails validateUser(UserDetails user) {

		log.info("validating user");
		Optional<Employee> employee1 = employeeRepository.findById(user.getUserId());
		Employee employee = employee1.orElseThrow(()->new InvalidUserIdException("Employee with given ID does not Exist ..!.. "));
		
		// condition to validate user
		if (user.getUserId() != employee.getUserId())
		{

			throw new InvalidUserIdException("The entrerd user id is incorrect");

		} 
		
		// condition to validate password
		else if (!user.getPassword().equals(employee.getPassword())) 
		{
			throw new PasswordIncorrectException("Entered password is incorrect");

		} 
		
		//condition to validate role
		else if (!user.getRole().equals(employee.getRole())) 
		{
			throw new RoleNotFoundException("Entered role for the above credentials is incorrect");
		} else 
		{
			/*
			 * UserDetails verifiedUser = new UserDetails();
			 * 
			 * verifiedUser.setUserId(user.getUserId());
			 * verifiedUser.setPassword(user.getPassword());
			 * verifiedUser.setRole(user.getRole());
			 * verifiedUser.setResult(user.getResult());
			 */
		
			return user;
		}

	}

}
