package com.example.mappingdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mappingdemo.model.Employee;
import com.example.mappingdemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addOrUpdate(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public boolean deleteById(long id) {
		employeeRepository.deleteById(id);
		return true;
	}
	
	public Employee getIdByName(String empName) {
		return employeeRepository.getIdByName(empName);
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public Employee getById(long id) {
		return employeeRepository.findById(id).get();
	}

}
