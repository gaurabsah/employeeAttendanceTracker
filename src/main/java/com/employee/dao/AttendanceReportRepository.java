package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.AttendanceReport;

public interface AttendanceReportRepository extends JpaRepository<AttendanceReport, Long> {

}
