package com.cg.ems.entities;

//Lodin Module done by Sreeharsha A


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ApiModel
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserDetails {
	
	@ApiModelProperty(notes = "userID is aprimary Key can not be null or blank", example = "2021001", required = true)
	@Id
	@Column(nullable = false)
	private int userId;
	
	@ApiModelProperty(notes = "password can not be null or blank", example = "harsha@123", required = true)
	@Column(nullable = false)
	private String password;

	@ApiModelProperty(notes = "role can not be null or blank", example = "manager", required = true)
	@Column(nullable = false)
	private String role;
	
	@ApiModelProperty(notes = "first name can not be null or blankresult is optional", example = "85", required = false)
	@Column(nullable = true)
	private int result;
	
}
