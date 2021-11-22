package com.example.demo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitybean.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> findByAgeSalary(int age, int salary) {
		return employeeRepository.findByAgeSalary(age, salary);
	}
	
	public List<Employee> getEmployeeByName(String empName) {
		List<Employee> empList = employeeRepository.findAll();
		return empList.stream().filter(emp -> emp.getName().equals(empName)).collect(Collectors.toList());
	}

	
	public Employee getEmployee(int empID) {
		return employeeRepository.findById(empID).get();
	}
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee update(Employee emp) {
		if(emp.getEmpID() == null || emp.getName() == null) {
			return null;
		}
		return employeeRepository.save(emp);
	}
}
