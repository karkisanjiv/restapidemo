package com.restapi.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.example.demo.dao.EmployeeContactRepository;
import com.restapi.example.demo.entities.Employee;

@Service
public class EmployeeContactServiceImpl implements EmployeeContactService{

	@Autowired
	private EmployeeContactRepository employeeContactRepository;
	
	public EmployeeContactServiceImpl(EmployeeContactRepository employeeContactRepo) {
		this.employeeContactRepository = employeeContactRepo;
	}

	@Override
	public List<Employee> findAll() {
		return employeeContactRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		
		Optional<Employee> result =employeeContactRepository.findById(theId);
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		
		else {
			throw new RuntimeException("Employee Not Found");
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeContactRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeContactRepository.deleteById(theId);
		
	}
	
	
	
	
	
	
	
}
