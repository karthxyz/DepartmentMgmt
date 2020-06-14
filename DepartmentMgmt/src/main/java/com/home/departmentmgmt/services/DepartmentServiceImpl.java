package com.home.departmentmgmt.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.departmentmgmt.bean.DepartmentBean;
import com.home.departmentmgmt.dto.DepartmentDTO;
import com.home.departmentmgmt.exception.ResourceNotFoundException;
import com.home.departmentmgmt.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository depRepository;

	@Autowired
	private DepartmentDTO departmentDTO;

	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	public DepartmentBean addDepartment(DepartmentBean addDepartment) {

		departmentDTO = new DepartmentDTO();
		System.out.println(departmentDTO);
		logger.info("DepartmentDTO object:", departmentDTO);
		departmentDTO.setDeptName(addDepartment.getDeptName());
		departmentDTO.setSubject1(addDepartment.getSubject1());
		departmentDTO.setSubject2(addDepartment.getSubject2());
		departmentDTO.setSubject3(addDepartment.getSubject3());
		departmentDTO = depRepository.saveAndFlush(departmentDTO);
		addDepartment.setDeptID(departmentDTO.getDeptID());
		return addDepartment;
	}

	public DepartmentBean findByDeptId(Long deptID) {

		departmentDTO = new DepartmentDTO();
		DepartmentBean departmentBean = new DepartmentBean();
		departmentDTO = depRepository.findById(deptID).orElse(null);
		if (departmentDTO == null)
			throw new ResourceNotFoundException("Department not found");
		departmentBean.setDeptID(departmentDTO.getDeptID());
		departmentBean.setDeptName(departmentDTO.getDeptName());
		departmentBean.setSubject1(departmentDTO.getSubject1());
		departmentBean.setSubject2(departmentDTO.getSubject2());
		departmentBean.setSubject3(departmentDTO.getSubject3());

		return departmentBean;


	}

}
