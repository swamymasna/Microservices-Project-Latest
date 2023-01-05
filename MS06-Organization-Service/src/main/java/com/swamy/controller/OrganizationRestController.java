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

import com.swamy.payload.OrganizationDTO;
import com.swamy.service.IOrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationRestController {

	@Autowired
	private IOrganizationService organizationService;

	@PostMapping("/save")
	public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {

		OrganizationDTO organization = organizationService.saveOrganization(organizationDTO);
		return new ResponseEntity<OrganizationDTO>(organization, HttpStatus.CREATED);
	}

	@GetMapping("/{organization_code}")
	public ResponseEntity<OrganizationDTO> getOrganizationByCode(
			@PathVariable(value = "organization_code") String orgCode) {

		OrganizationDTO organization = organizationService.getOrganizationByCode(orgCode);
		return ResponseEntity.ok(organization);
	}
}
