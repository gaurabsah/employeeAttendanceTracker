package com.employee.service;

import java.util.List;

import com.employee.dto.CompanyDTO;

public interface CompanyService {

	CompanyDTO saveCompanyDetails(CompanyDTO dto);

	CompanyDTO getCompanyDetails(long id);

	CompanyDTO updateCompanyDetails(long id, CompanyDTO dto);

	List<CompanyDTO> getAllCompanyDetails();

	CompanyDTO getCompanyDetailsByName(String companyName);

}
