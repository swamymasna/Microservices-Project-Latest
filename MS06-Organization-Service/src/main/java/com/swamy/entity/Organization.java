package com.swamy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "ORGANIZATION_TBL")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "organizationName")
	private String organizationName;

	@Column(name = "organizationDescription")
	private String organizationDescription;

	@Column(name = "organizationCode")
	private String organizationCode;

	@CreationTimestamp
	@Column(name = "createdDate")
	private LocalDateTime createdDate;

}
