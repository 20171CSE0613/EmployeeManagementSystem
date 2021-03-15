package com.cg.ems.entities;

//Employee Module done by Saniya Khanum A


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Employee extends UserDetails {

	@ApiModelProperty(notes = "first name can not be null or blank", example = "sreeharsha", required = true)
	@Column(nullable = true)
	private String firstName;

	@ApiModelProperty(notes = "lastname is optional", example = "Apparaju", required = false)
	@Column(nullable = true)
	private String lastName;

	@ApiModelProperty(notes = "date of birth can not be null or blank", example = "2000-05-22", required = true)
	@Column(nullable = false)
	private String dob;

	@ApiModelProperty(notes = "emailId can not be null or blank", example = "harsha@gmail.com", required = true)
	@Column(nullable = false)
	private String email;

	//@Column
	//private Department department;

}
