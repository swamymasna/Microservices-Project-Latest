package com.swamy.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.entity.Department;
import com.swamy.exception.ResourceNotFoundException;
import com.swamy.payload.DepartmentDTO;
import com.swamy.repository.DepartmentRepository;
import com.swamy.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

		Department department = mapper.map(departmentDTO, Department.class);

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDTO departmentResponse = mapper.map(savedDepartment, DepartmentDTO.class);

		return departmentResponse;
	}

	@Override
	public DepartmentDTO getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDTO departmentObj = mapper.map(department, DepartmentDTO.class);

		return departmentObj;
	}
}

