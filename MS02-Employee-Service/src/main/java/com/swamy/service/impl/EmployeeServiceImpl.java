package com.swamy.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.swamy.client.ApiClient;
import com.swamy.entity.Employee;
import com.swamy.exception.ResourceNotFoundException;
import com.swamy.payload.APIResponse;
import com.swamy.payload.DepartmentDTO;
import com.swamy.payload.EmployeeDTO;
import com.swamy.payload.OrganizationDTO;
import com.swamy.repository.EmployeeRepository;
import com.swamy.service.IEmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ApiClient apiClient;
	
	@Autowired
	private WebClient webClient;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

		Employee employee = mapper.map(employeeDTO, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDTO employeeResponse = mapper.map(savedEmployee, EmployeeDTO.class);
		return employeeResponse;
	}

	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "defaultGetEmployeeById")
	@Override
	public APIResponse getEmployeeById(Integer id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Id : " + id));
		EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);

		
		//Communicating with DEPARTMENT-SERVICE using Feign Client
		DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

		//Communicating with ORGANIZATION-SERVICE using Web Client
		OrganizationDTO organizationDTO = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve().bodyToMono(OrganizationDTO.class).block();
		
		APIResponse apiResponse = new APIResponse();
		apiResponse.setEmployee(employeeDTO);
		apiResponse.setDepartment(departmentDTO);
		apiResponse.setOrganization(organizationDTO);
		return apiResponse;
	}
	
	
	public APIResponse defaultGetEmployeeById(Integer id, Exception exception) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Id : " + id));
		EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);

		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setId(100);
		departmentDTO.setDepartmentName("DEFAULT-NAME");
		departmentDTO.setDepartmentDescription("DEFAULT-DESC");
		departmentDTO.setDepartmentCode("DEF001");

		APIResponse apiResponse = new APIResponse();
		apiResponse.setEmployee(employeeDTO);
		apiResponse.setDepartment(departmentDTO);
		return apiResponse;
	}

}

