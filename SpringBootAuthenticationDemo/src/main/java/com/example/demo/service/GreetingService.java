package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitybean.Greeting;
import com.example.demo.repository.GreetingRepository;

@Service
public class GreetingService {

	@Autowired
	GreetingRepository greetingRepository;
	
	
	public List<Greeting> getAllGreeting() {
		Iterable<Greeting> iterable = greetingRepository.findAll();
	    List<Greeting> greeting = new ArrayList<Greeting>();
	    iterable.forEach(greeting::add);
	    return greeting;
	}
	
	public Greeting saveGreeting(Greeting greeting) {
		Greeting returnData = greetingRepository.save(greeting);
	    return returnData;
	}
}
