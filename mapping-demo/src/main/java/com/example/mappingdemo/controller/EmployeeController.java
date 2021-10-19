package com.example.mappingdemo.controller;

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

import com.example.mappingdemo.model.Employee;
import com.example.mappingdemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping
	private List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@GetMapping("/{name}")
	private Employee getIdByName(@PathVariable String empName) {
		return employeeService.getIdByName(empName);
	}
	
	@GetMapping("/{id}")
	private Employee getById(@PathVariable long id) {
		return employeeService.getById(id);
	}
	
	@PostMapping
	private Employee add(@RequestBody Employee employee) {
		return employeeService.addOrUpdate(employee);
	}
	
	@PutMapping("/{id}")
	private Employee update(@PathVariable long id, @RequestBody Employee employee) {
		employee.setEmpId(id);
		return employeeService.addOrUpdate(employee);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable long id) {
		employeeService.deleteById(id);
	}

}
