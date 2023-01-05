package com.swamy.service;

import com.swamy.payload.APIResponse;
import com.swamy.payload.EmployeeDTO;

public interface IEmployeeService {

	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
	
	public APIResponse getEmployeeById(Integer id);
}

