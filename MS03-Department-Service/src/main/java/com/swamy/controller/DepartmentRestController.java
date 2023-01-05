package com.swamy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.payload.DepartmentDTO;
import com.swamy.service.IDepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {

	@Autowired
	private IDepartmentService departmentService;

	@PostMapping("/save")
	public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {

		DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);

		return new ResponseEntity<DepartmentDTO>(savedDepartment, HttpStatus.CREATED);
	}

	@GetMapping("/{department_code}")
	public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable(value = "department_code") String deptCode) {

		DepartmentDTO department = departmentService.getDepartmentByCode(deptCode);

		return new ResponseEntity<DepartmentDTO>(department, HttpStatus.OK);
	}
}
