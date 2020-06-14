package com.home.departmentmgmt.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.departmentmgmt.bean.DepartmentBean;
import com.home.departmentmgmt.exception.ResourceNotFoundException;
import com.home.departmentmgmt.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	public DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentBean> addDepartment(@Valid @RequestBody DepartmentBean db) {
		System.out.println("controller:DepartmentBean: " + db);
		DepartmentBean result = departmentService.addDepartment(db);
		logger.info("DepartmentBean: ", result);
		return ResponseEntity.ok(result);

	}

	@GetMapping(path = "/{param}")
	public ResponseEntity<DepartmentBean> findByDeptId(@PathVariable("param") Long deptID)
			throws ResourceNotFoundException {
		DepartmentBean result = departmentService.findByDeptId(deptID);
		return new ResponseEntity<DepartmentBean>(result, HttpStatus.OK);

	}

	/*
	 * @GetMapping(path="/{param}") public DepartmentBean
	 * findByDeptId(@PathVariable("param") Long deptID) throws
	 * ResourceNotFoundException{ DepartmentBean result =
	 * departmentService.findByDeptId(deptID); return result;
	 * 
	 * }
	 */

}
