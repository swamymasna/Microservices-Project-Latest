package com.swamy.service;

import com.swamy.payload.OrganizationDTO;

public interface IOrganizationService {

	public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);

	public OrganizationDTO getOrganizationByCode(String organizationCode);

}
