package com.example.demo.restController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitybean.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(value = "age", defaultValue = "0") int age, 
			@RequestParam(value = "salary", defaultValue = "0") int salary) {
		
		System.out.println("age: "+ age + " : "+ salary);
		List<Employee> empList = employeeService.findByAgeSalary(age, salary);
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		
		Employee emp = employeeService.getEmployee(id);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") int id, @RequestBody Employee emp) {
		
		emp.setId(id);
		Employee employee = employeeService.update(emp);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity update(@PathVariable("id") int id) {
		employeeService.delete(id);
		ResponseEntity response = new ResponseEntity(HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> save(@RequestBody Employee emp) {
		emp.setId(0);
		emp.setPassword(bCryptPasswordEncoder.encode( emp.getPassword() ));
		Employee employee = employeeService.save(emp);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return response;
	}
	
	
}
