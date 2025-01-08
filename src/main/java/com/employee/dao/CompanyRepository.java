package com.employee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	Optional<Company> findByCompanyName(String companyName);

}
