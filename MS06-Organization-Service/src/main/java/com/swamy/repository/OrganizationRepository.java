package com.swamy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swamy.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

	Organization findByOrganizationCode(String organizationCode);
}
