package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<EmployeeDTO> saveEmployeeDetails(@RequestBody EmployeeDTO dto) {
		EmployeeDTO employeeDetails = employeeService.saveEmployeeDetails(dto);
		return new ResponseEntity<EmployeeDTO>(employeeDetails, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeDTO> updateEmployeeDetails(@RequestParam long id, @RequestBody EmployeeDTO dto) {
		EmployeeDTO employeeDetails = employeeService.updateEmployeeDetails(id, dto);
		return new ResponseEntity<EmployeeDTO>(employeeDetails, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<EmployeeDTO> getEmployeeDetails(@RequestParam long id) {
		EmployeeDTO employeeDetails = employeeService.getEmployeeDetails(id);
		return new ResponseEntity<EmployeeDTO>(employeeDetails, HttpStatus.FOUND);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeDetails() {
		List<EmployeeDTO> employeeDetails = employeeService.getAllEmployeesDetails();
		return new ResponseEntity<>(employeeDetails, HttpStatus.FOUND);
	}

}
