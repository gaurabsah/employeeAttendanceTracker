package com.employee.model;

import java.util.List;

import com.employee.enums.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "company_tbl")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String companyName;
	
	private String about;
	
	@Enumerated(EnumType.STRING)
	private Location location;
	
//	company can have more than one employees
	@OneToMany(mappedBy = "company")
	private List<Employee> employees;

}
