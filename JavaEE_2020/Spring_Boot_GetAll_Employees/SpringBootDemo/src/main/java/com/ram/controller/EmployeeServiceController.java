package com.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.model.Employee;
import com.ram.service.EmployeeService;

@RestController
public class EmployeeServiceController
{
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee)
	{
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(
				"Employee is created successfully with Id = " + employee.getId(),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id,
			@RequestBody Employee employee)
	{
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id)
	{
		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees()
	{
		List<Employee> employeeList = employeeService.getEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

}
