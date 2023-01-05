package com.swamy.payload;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String departmentCode;
	
	private String organizationCode;
}
