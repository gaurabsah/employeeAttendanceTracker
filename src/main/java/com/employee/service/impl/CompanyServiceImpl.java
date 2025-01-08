package com.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.employee.dao.CompanyRepository;
import com.employee.dto.CompanyDTO;
import com.employee.exception.ResourceAlreadyExistsException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Company;
import com.employee.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;

	private final ModelMapper mapper;

	@Override
	public CompanyDTO saveCompanyDetails(CompanyDTO dto) {
		// Check for duplicate company name
		if (companyRepository.findByCompanyName(dto.getCompanyName()).isPresent()) {
			throw new ResourceAlreadyExistsException("Company with this name already exists.");
		}

		Company company = mapper.map(dto, Company.class);
		company = companyRepository.save(company);
		return mapper.map(company, CompanyDTO.class);
	}

	@Override
	public CompanyDTO getCompanyDetails(long id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company with this id do not exists."));

		return mapper.map(company, CompanyDTO.class);
	}

	@Override
	public CompanyDTO updateCompanyDetails(long id, CompanyDTO dto) {
		// Find the existing company by id
		Company existingCompany = companyRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Company with ID " + id + " not found"));

		// Check if the Company details from the DTO are provided, and update
		// accordingly
		if (dto.getCompanyName() != null) {
			existingCompany.setCompanyName(dto.getCompanyName());
		}

		if (dto.getAbout() != null) {
			existingCompany.setAbout(dto.getAbout());
		}

		if (dto.getLocation() != null) {
			existingCompany.setLocation(dto.getLocation());
		}

		// Save the updated company entity
		existingCompany = companyRepository.save(existingCompany);
		return mapper.map(existingCompany, CompanyDTO.class);
	}

	@Override
	public List<CompanyDTO> getAllCompanyDetails() {
		List<Company> companies = companyRepository.findAll();
		List<CompanyDTO> companyDTOs = companies.stream().map(company -> mapper.map(company, CompanyDTO.class))
				.collect(Collectors.toList());

		return companyDTOs;
	}

	@Override
	public CompanyDTO getCompanyDetailsByName(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName)
				.orElseThrow(() -> new ResourceNotFoundException("Company with this name do not exists."));

		return mapper.map(company, CompanyDTO.class);
	}

}
