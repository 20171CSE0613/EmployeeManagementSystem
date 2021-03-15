package com.cg.ems.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.entities.UserDetails;
import com.cg.ems.exception.UserCredentialsInvalidException;
import com.cg.ems.repository.ILoginRepository;
import com.cg.ems.service.ILoginService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceTest {
	
	@Autowired
	private ILoginService loginService;
	
	@MockBean
	private ILoginRepository loginRepository;
	
	
	UserDetails user = null;
	
	@BeforeEach	
	public void beforeTest() {
		user = new UserDetails();
		
		user.setUserId(1);
		user.setPassword("123456");
		user.setRole("manager");
		user.setResult(69);
	}
	
	
	@Test
	public void testLogin() throws UserCredentialsInvalidException {
		
		when(loginRepository.save(user)).thenReturn(user);
		when(loginRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		assertEquals(user, loginService.validateUser(user));	
		
	}
	
	@AfterEach
	public void afterTest() {
		user=null;
	}


}
