package com.swamy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.swamy.payload.DepartmentDTO;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

	@GetMapping("/api/departments/{department_code}")
	public DepartmentDTO getDepartmentByCode(@PathVariable(value = "department_code") String deptCode);
}
