package com.restapi.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restapi.example.demo.entities.Employee;

public interface EmployeeContactRepository extends JpaRepository<Employee,Integer> {

}
