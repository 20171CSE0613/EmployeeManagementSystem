package com.cg.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.ems.service.LoginServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
public class EmsysApplication {
	private final static Logger log = LogManager.getLogger(LoginServiceImpl.class);

	public static void main(String[] args) {
		log.info("Application Started");

		SpringApplication.run(EmsysApplication.class, args);
		
		log.info("Applications is Stopped");

	}

}
