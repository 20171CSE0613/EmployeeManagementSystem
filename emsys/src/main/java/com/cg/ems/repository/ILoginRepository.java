package com.cg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ems.entities.UserDetails;


public interface ILoginRepository extends JpaRepository<UserDetails, Integer>  {
	
	
}
