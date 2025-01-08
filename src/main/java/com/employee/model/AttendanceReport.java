package com.employee.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class AttendanceReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/*
	 * employee - empNumber,name,email date true/false - present/absent
	 */

	@CurrentTimestamp
	private LocalDateTime date;

	private boolean isPresent;

	@OneToOne(mappedBy = "attendanceReport", cascade = CascadeType.ALL)
	private Employee employee;

}
