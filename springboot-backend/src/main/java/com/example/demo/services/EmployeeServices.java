package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Employee;
public interface EmployeeServices {
	Employee saveEmployee(Employee employee);
	List<Employee> getEmployees();
	Employee getEmployee(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
//	void deleteEmployee(long id);

}
