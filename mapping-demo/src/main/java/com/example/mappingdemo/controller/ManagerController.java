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

import com.example.mappingdemo.model.Manager;
import com.example.mappingdemo.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@GetMapping
	private List<Manager> getAll() {
		return managerService.getAll();
	}
	
	@GetMapping("/{id}")
	private Manager getById(@PathVariable long id) {
		return managerService.getById(id);
	}
	
	@PostMapping
	private Manager add(@RequestBody Manager manager) {
		return managerService.addOrUpdate(manager);
	}
//	
	@PutMapping("/{id}")
	private Manager update(@PathVariable long id, @RequestBody Manager manager) {
		return managerService.addOrUpdate(manager);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable long id) {
		managerService.deleteById(id);
	}


}
