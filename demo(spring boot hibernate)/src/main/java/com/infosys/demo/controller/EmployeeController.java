package com.infosys.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.demo.dao.EmployeeDao;
import com.infosys.demo.model.Employee;

@RestController
@RequestMapping("/hello")
public class EmployeeController{
	
	@Autowired
	private EmployeeDao employeeService;
	
	//@RequestMapping(value="/hello", method= RequestMethod.POST)
     @PostMapping(value= "/createUser")
    public String create(@RequestBody Employee employee) {
		String response=null;
        try { 
           System.out.println(employee.getName());
         response= employeeService.saveEmployee(employee);
       } catch (Exception ex) {
            return ex.getMessage();
        }
        return response;
    }
	
    @GetMapping("/allEmployees")
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeService.getAllEmployee();
		return list;
	}
}



