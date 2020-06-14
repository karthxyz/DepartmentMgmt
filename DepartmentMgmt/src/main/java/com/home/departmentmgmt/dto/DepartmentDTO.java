package com.home.departmentmgmt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "department")
@Table(name = "department")
@Scope(value="prototype")
@Component
@SequenceGenerator(name="dept_id_seq", initialValue=100, allocationSize=100)

public class DepartmentDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_id_seq" )
	@Column(name = "DEPT_ID")
	private long deptID;
	
	@Column(name = "DEPT_NAME")
	private String deptName;
	
	@Column(name = "SUBJECT_1")
	private String subject1;
	
	@Column(name = "SUBJECT_2")
	private String subject2;
	
	@Column(name = "SUBJECT_3")
	private String subject3;
	

}
