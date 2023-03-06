package com.example.demo.services.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeServices;

@Service
@Component
public class EmployeeServicesImpl implements  EmployeeServices {
private EmployeeRepository employeeRepository;

public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
	super();
	this.employeeRepository = employeeRepository;
}
@Override
public Employee saveEmployee( Employee employee) {
	return employeeRepository.save(employee);
}
@Override
public List<Employee> getEmployees() {
	
	return employeeRepository.findAll();
}

@Override
public Employee getEmployee(long id) {
	return  employeeRepository.getById( id);
}

@Override
public Employee updateEmployee(Employee employee, long id) {
	Employee existingEmployee= employeeRepository.findById(id).orElseThrow( );	
	existingEmployee.setFirstname(employee.getFirstname());
	existingEmployee.setLastname(employee.getLastname());
	existingEmployee.setEmail(employee.getEmail());
	employeeRepository.save(existingEmployee);
	return existingEmployee;
}
@Override
public void deleteEmployee(long id) {
	employeeRepository.findById(id).orElseThrow( );
	employeeRepository.deleteById(id);	
}


}
