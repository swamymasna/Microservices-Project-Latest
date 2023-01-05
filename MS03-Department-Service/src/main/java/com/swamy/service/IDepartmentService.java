package com.swamy.service;

import com.swamy.payload.DepartmentDTO;

public interface IDepartmentService {

	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

	public DepartmentDTO getDepartmentByCode(String departmentCode);
}
