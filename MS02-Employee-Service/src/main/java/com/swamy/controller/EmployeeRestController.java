package com.swamy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.payload.APIResponse;
import com.swamy.payload.EmployeeDTO;
import com.swamy.service.IEmployeeService;

@RefreshScope
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Value("${app.message}")
	private String message;

	@PostMapping("/save")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeReq) {

		EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeReq);
		return new ResponseEntity<EmployeeDTO>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getEmployeeById(@PathVariable(value = "id") Integer empId) {
		APIResponse apiResponse = employeeService.getEmployeeById(empId);
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/message")
	public String showMessage() {
		return message;
	}

}
