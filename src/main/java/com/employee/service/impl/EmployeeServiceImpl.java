package com.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.dto.EmployeeDTO;
import com.employee.exception.ResourceAlreadyExistsException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	private final ModelMapper mapper;

	@Override
	public EmployeeDTO saveEmployeeDetails(EmployeeDTO dto) {
		// Check for duplicate email or employee number
		if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
			throw new ResourceAlreadyExistsException("Employee with this email already exists.");
		}

		if (employeeRepository.findByEmployeeNumber(dto.getEmployeeNumber()).isPresent()) {
			throw new ResourceAlreadyExistsException("Employee with this employee number already exists.");
		}

		Employee employee = mapper.map(dto, Employee.class);
		employee = employeeRepository.save(employee);
		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO getEmployeeDetails(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with this id do not exists."));

		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO updateEmployeeDetails(long id, EmployeeDTO dto) {
		// Find the existing employee by id
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Employee with ID " + id + " not found"));

		// Check if the employee details from the DTO are provided, and update
		// accordingly
		if (dto.getFirstName() != null) {
			existingEmployee.setFirstName(dto.getFirstName());
		}

		if (dto.getLastName() != null) {
			existingEmployee.setLastName(dto.getLastName());
		}

		if (dto.getEmail() != null && !dto.getEmail().equals(existingEmployee.getEmail())) {
			// Optionally, check if the new email is unique
			if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
				throw new IllegalArgumentException("An employee with this email already exists.");
			}
			existingEmployee.setEmail(dto.getEmail());
		}

		if (dto.getEmployeeNumber() != 0 && dto.getEmployeeNumber() != existingEmployee.getEmployeeNumber()) {
			// Optionally, check if the new employee number is unique
			if (employeeRepository.findByEmployeeNumber(dto.getEmployeeNumber()).isPresent()) {
				throw new IllegalArgumentException("An employee with this employee number already exists.");
			}
			existingEmployee.setEmployeeNumber(dto.getEmployeeNumber());
		}

		if (dto.getGender() != null) {
			existingEmployee.setGender(dto.getGender());
		}

		if (dto.getDesignation() != null) {
			existingEmployee.setDesignation(dto.getDesignation());
		}

		if (dto.getReportingLocation() != null) {
			existingEmployee.setReportingLocation(dto.getReportingLocation());
		}

		// Save the updated employee entity
		existingEmployee = employeeRepository.save(existingEmployee);
		return mapper.map(existingEmployee, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> getAllEmployeesDetails() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = employees.stream().map(employee -> mapper.map(employee, EmployeeDTO.class))
				.collect(Collectors.toList());

		return employeeDTOs;
	}

}
