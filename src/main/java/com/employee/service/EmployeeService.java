package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO saveEmployeeDetails(EmployeeDTO dto);

	EmployeeDTO getEmployeeDetails(long id);

	EmployeeDTO updateEmployeeDetails(long id, EmployeeDTO dto);

	List<EmployeeDTO> getAllEmployeesDetails();
	
/*
 * TODO:
 * 1. find employees by company name
 * 2. record employee office in-time and out-time
 */

}
