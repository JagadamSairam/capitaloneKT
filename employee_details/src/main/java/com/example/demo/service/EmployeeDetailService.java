package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeDetailEntity;
import com.example.demo.repository.EmployeeDetailRepository;

@Service
public class EmployeeDetailService {

	@Autowired
	EmployeeDetailRepository employeeDetailRepository;

	// Adding new Employee Details
	public EmployeeDetailEntity addEmployee(EmployeeDetailEntity employeeEntity) {
		EmployeeDetailEntity employee = new EmployeeDetailEntity();
		BeanUtils.copyProperties(employeeEntity, employee);
		employeeDetailRepository.save(employee);
		return employeeEntity;
	}

	// Get Employee Details By ID
	public EmployeeDetailEntity getEmployeeDetails(int id) {
		Optional<EmployeeDetailEntity> employees = employeeDetailRepository.findById(id);
		EmployeeDetailEntity employee = new EmployeeDetailEntity();
		BeanUtils.copyProperties(employees.orElse(new EmployeeDetailEntity()), employee);
		return employee;
	}

	// Updating Employee Details
	public EmployeeDetailEntity updateEmployee(EmployeeDetailEntity employeeEntity) {
		EmployeeDetailEntity employee = new EmployeeDetailEntity();
		BeanUtils.copyProperties(employeeEntity, employee);
		employeeDetailRepository.save(employee);
		return employeeEntity;

	}

}
