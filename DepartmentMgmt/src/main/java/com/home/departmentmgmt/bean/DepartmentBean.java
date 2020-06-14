package com.home.departmentmgmt.bean;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DepartmentBean {
	private long deptID;

	@NotBlank(message = "deptName may not be null")
	private String deptName;

	@NotBlank(message = "subject1 may not be null")
	private String subject1;

	private String subject2;

	private String subject3;
}
