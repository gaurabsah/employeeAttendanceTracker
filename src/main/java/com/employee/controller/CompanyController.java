package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.CompanyDTO;
import com.employee.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

	private final CompanyService companyService;

	@PostMapping("/save")
	public ResponseEntity<CompanyDTO> saveDetails(@RequestBody CompanyDTO dto) {
		CompanyDTO companyDTO = companyService.saveCompanyDetails(dto);
		return new ResponseEntity<>(companyDTO, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<CompanyDTO> updateDetails(@RequestParam long id, @RequestBody CompanyDTO dto) {
		CompanyDTO companyDTO = companyService.updateCompanyDetails(id, dto);
		return new ResponseEntity<>(companyDTO, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<CompanyDTO> getDetails(@RequestParam long id) {
		CompanyDTO companyDTO = companyService.getCompanyDetails(id);
		return new ResponseEntity<>(companyDTO, HttpStatus.FOUND);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<CompanyDTO>> getAllDetails() {
		List<CompanyDTO> companyDTOs = companyService.getAllCompanyDetails();
		return new ResponseEntity<>(companyDTOs, HttpStatus.FOUND);
	}

	@GetMapping("/get/name")
	public ResponseEntity<CompanyDTO> getDetailsByName(@RequestParam String companyName) {
		CompanyDTO companyDTO = companyService.getCompanyDetailsByName(companyName);
		return new ResponseEntity<>(companyDTO, HttpStatus.FOUND);
	}

}
