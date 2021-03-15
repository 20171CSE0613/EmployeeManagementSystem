package com.cg.ems;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.regex("/ems/.*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.ems"))
				.build()
				.apiInfo(getApiInfo());
	}
    
    private ApiInfo getApiInfo() {
	    return new ApiInfo(
		    "Employee Managemment System",
		    "Authors: Seeharsha",
		    "1.0.0",
		    "https://ems.cg.com",
		    new Contact("Batch 7, Group 7 Sogeti","https://capgemini.com","group1@postgres"),
		    "GNU V3",
		    "LICENSE URL",
		    Collections.emptyList()
	    );
	}
}
