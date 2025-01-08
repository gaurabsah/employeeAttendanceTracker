package com.employee.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceReportDTO {
	
	@CurrentTimestamp
	private LocalDateTime date;

	private boolean isPresent;

	private EmployeeDTO employee;

}
