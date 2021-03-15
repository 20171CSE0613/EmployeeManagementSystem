package com.cg.ems.service;

import com.cg.ems.entities.UserDetails;

public interface ILoginService {
	
	public UserDetails validateUser(UserDetails user);
}
