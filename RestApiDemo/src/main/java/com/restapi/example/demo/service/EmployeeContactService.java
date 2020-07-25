package com.restapi.example.demo.service;

import java.util.List;

import com.restapi.example.demo.entities.Employee;


public interface EmployeeContactService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
