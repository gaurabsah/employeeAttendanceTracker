package com.employee.dto;

import com.employee.enums.Designation;
import com.employee.enums.Gender;
import com.employee.enums.Location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
	
	private String firstName;

	private String lastName;

	private long employeeNumber;

	private String email;

	private Gender gender;

	private Designation designation;

	private Location reportingLocation;

	private CompanyDTO company;

	private AttendanceReportDTO attendanceReport;


}
