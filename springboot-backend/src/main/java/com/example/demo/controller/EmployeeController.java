package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeServices;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController<employee> {
	
private EmployeeServices employeeServices;

public EmployeeController(EmployeeServices employeeServices) {
	super();
	this.employeeServices = employeeServices;
}

@PostMapping("/save")
ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeServices.saveEmployee(employee),HttpStatus.CREATED);
}
@GetMapping
 public List<Employee> getEmployees(){
	return employeeServices.getEmployees();
}
@GetMapping("/{id}")
public Employee getEmployee(@PathVariable("id") long id){
	return employeeServices.getEmployee(id);
}
@PutMapping("/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeServices.updateEmployee(employee,id),HttpStatus.OK);
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
      employeeServices.deleteEmployee(id);
    return new ResponseEntity<String>("deleted record sucessfully",HttpStatus.OK);
}
}