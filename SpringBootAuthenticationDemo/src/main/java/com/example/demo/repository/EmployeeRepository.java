package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entitybean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "SELECT emp FROM Employee emp WHERE emp.age >= :age AND emp.salary >= :salary")
	List<Employee> findByAgeSalary(@Param("age") int age, @Param("salary") int salary);
	
	@Query("SELECT emp FROM Employee emp where emp.userName = :userName")
	Employee getByUserName(@Param("userName") String userName);
	
}
