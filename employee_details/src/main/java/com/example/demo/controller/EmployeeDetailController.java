package com.example.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeDetailEntity;
import com.example.demo.repository.EmployeeDetailRepository;
import com.example.demo.service.EmployeeDetailService;

@RestController
public class EmployeeDetailController {
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeDetailRepository employeeDetailRepository;

	@GetMapping("/employeedetails/{id}")
	public ResponseEntity<?> getSearchedEmployees(@PathVariable int id) {
		try {
			EmployeeDetailEntity emp = employeeDetailService.getEmployeeDetails(id);
			return new ResponseEntity<EmployeeDetailEntity>(emp, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("no such employee found", HttpStatus.OK);
		}
	}

	@PostMapping("/add/employee")
	public EmployeeDetailEntity addEmployee(@RequestBody EmployeeDetailEntity employeeDetails) {
		EmployeeDetailEntity employee = employeeDetailService.addEmployee(employeeDetails);
		return employee;
	}

	@PutMapping("/edit/employee")
	public ResponseEntity<EmployeeDetailEntity> update(@RequestBody EmployeeDetailEntity employeeDetails) {

		EmployeeDetailEntity employee = employeeDetailService.updateEmployee(employeeDetails);
		return new ResponseEntity<EmployeeDetailEntity>(employee, HttpStatus.OK);
	}
}
