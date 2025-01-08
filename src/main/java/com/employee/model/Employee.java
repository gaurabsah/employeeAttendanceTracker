package com.employee.model;

import com.employee.enums.Designation;
import com.employee.enums.Gender;
import com.employee.enums.Location;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	private long employeeNumber;

	@Column(nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Designation designation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Location reportingLocation;

//	many employees belong to one company
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendanceId")
	private AttendanceReport attendanceReport;

}
