package com.swamy.payload;

import lombok.Data;

@Data
public class APIResponse {

	private EmployeeDTO employee;
	private DepartmentDTO department;
	private OrganizationDTO organization;
}
