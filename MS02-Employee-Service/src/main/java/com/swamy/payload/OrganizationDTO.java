package com.swamy.payload;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrganizationDTO {

	private Integer id;

	private String organizationName;

	private String organizationDescription;

	private String organizationCode;

	private LocalDateTime createdDate;

}
