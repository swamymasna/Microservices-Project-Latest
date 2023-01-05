package com.swamy.payload;

import lombok.Data;

@Data
public class DepartmentDTO {

	private Integer id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
}
