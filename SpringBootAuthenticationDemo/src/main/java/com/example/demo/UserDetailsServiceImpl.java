package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entitybean.Employee;
import com.example.demo.repository.EmployeeRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee emp = employeeRepository.getByUserName(username);
		
		if(emp == null) { throw new UsernameNotFoundException("User not found by given userName");		}
		
		return new LoginUserDetails(emp);
	}

	
}
