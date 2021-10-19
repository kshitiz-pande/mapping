package com.example.mappingdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mappingdemo.model.Manager;
import com.example.mappingdemo.repository.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	private ManagerRepository managerRepository;
	
	public Manager addOrUpdate(Manager manager) {
		return managerRepository.save(manager);
	}
	
	public boolean deleteById(long id) {
		managerRepository.deleteById(id);
		return true;
	}
	
	public List<Manager> getAll() {
		return managerRepository.findAll();
	}
	
	public Manager getById(long id) {
		return managerRepository.findById(id).get();
	}


}
