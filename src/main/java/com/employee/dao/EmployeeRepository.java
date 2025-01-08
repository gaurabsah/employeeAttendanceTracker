package com.employee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	// Check if an employee with the same email already exists
    Optional<Employee> findByEmail(String email);

    // Alternatively, check by employee number
    Optional<Employee> findByEmployeeNumber(long employeeNumber);

}
