package com.infosys.demo.dao;

import java.util.List;

import com.infosys.demo.model.Employee;

public interface EmployeeDao {
	public  String saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	}

