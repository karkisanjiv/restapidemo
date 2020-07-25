package com.restapi.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.example.demo.entities.Employee;
import com.restapi.example.demo.service.EmployeeContactService;

@RestController
@RequestMapping("/api")
public class ContactSystem {
	
	@Autowired
	private EmployeeContactService employeeContactService;

	public ContactSystem(EmployeeContactService empContactService) {
		this.employeeContactService = empContactService;
	}
	
	
	
	
	// return the list of all contacts
	@GetMapping("/contacts")
	public List<Employee> findAll() {
		return employeeContactService.findAll();
	}

	// Add mapping for GET
	@GetMapping("/contacts/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = employeeContactService.findById(id);
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		return employee;
	}

	// Creating new employee
	@PostMapping("/contacts")
	public Employee addEmployee(@RequestBody Employee theEmployee) {


		employeeContactService.save(theEmployee);

		return theEmployee;
	}

	// Update using PUT
	@PutMapping("/contacts/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") int theId, @RequestBody Employee theEmployee) {
		
		Employee employee = employeeContactService.findById(theId);
		
		if (employee == null) {
			throw new RuntimeException("Employee not found: " + theId);
		}
		employee = theEmployee;
		employeeContactService.save(employee);
		return employee;
	}

	// Deleting the employee
	@DeleteMapping("/contacts/{id}")
	public String deleteEmployee(@PathVariable(name = "id") int theId) {

		Employee employee = employeeContactService.findById(theId);

		if (employee == null) {
			throw new RuntimeException("Employee not found: " + theId);
		}

		employeeContactService.deleteById(theId);

		return "Deleted employee with id " + theId;
	}

}
