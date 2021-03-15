package com.cg.ems.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entities.UserDetails;
import com.cg.ems.exception.InvalidInputException;
import com.cg.ems.exception.UserCredentialsInvalidException;
import com.cg.ems.service.ILoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/ems/login")
@Api(description = "Controller of Login Module")
public class LoginController {
	
	public static final Logger Log = LogManager.getLogger(LoginController.class);
	
	
	
	// 
	@Autowired
	private ILoginService loginService;
	
	//Method to validate the User
	@ApiOperation(value = "Sign In controller method")
	@GetMapping( value = "/validateUser")
	public ResponseEntity<String> validateUser(@RequestBody UserDetails user) throws UserCredentialsInvalidException
	{
		
		Log.info("Controller Triggerd");
		if(user.getUserId() == 0 || user.getPassword() == null || user.getPassword().equals("")) {
			Log.error("input details re wrong");
			throw new InvalidInputException("Username or Password cannot be null!");
		}
		UserDetails result=loginService.validateUser(user);
		return new ResponseEntity<String>("Login Successful",HttpStatus.OK);
			
	}

}
