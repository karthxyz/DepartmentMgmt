package com.home.departmentmgmt.services;

import com.home.departmentmgmt.bean.DepartmentBean;


public interface DepartmentService {

	public DepartmentBean addDepartment(DepartmentBean addDepartment);
	public DepartmentBean findByDeptId(Long deptID) ;
}
