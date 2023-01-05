package com.swamy.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.entity.Organization;
import com.swamy.payload.OrganizationDTO;
import com.swamy.repository.OrganizationRepository;
import com.swamy.service.IOrganizationService;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

		Organization organization = mapper.map(organizationDTO, Organization.class);
		Organization savedOrganization = organizationRepository.save(organization);
		OrganizationDTO organizationResponse = mapper.map(savedOrganization, OrganizationDTO.class);
		return organizationResponse;
	}

	@Override
	public OrganizationDTO getOrganizationByCode(String organizationCode) {

		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

		OrganizationDTO organizationDTO = mapper.map(organization, OrganizationDTO.class);

		return organizationDTO;
	}

}
