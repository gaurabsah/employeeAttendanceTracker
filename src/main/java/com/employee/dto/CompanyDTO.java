package com.employee.dto;

import java.util.List;

import com.employee.enums.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

	private String companyName;

	private String about;

	private Location location;

	private List<EmployeeDTO> employees;

}
