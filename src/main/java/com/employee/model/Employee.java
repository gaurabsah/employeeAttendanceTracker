package com.employee.model;

import com.employee.enums.Designation;
import com.employee.enums.Gender;
import com.employee.enums.Location;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;

	private String lastName;

	private long employeeNumber;

	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Designation designation;

	private Location reportingLocation;

//	many employees belong to one company
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendanceId")
	private AttendanceReport attendanceReport;

}
