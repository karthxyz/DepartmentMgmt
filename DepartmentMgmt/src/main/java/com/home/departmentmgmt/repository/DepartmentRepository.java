package com.home.departmentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.departmentmgmt.dto.DepartmentDTO;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Long> {

}
