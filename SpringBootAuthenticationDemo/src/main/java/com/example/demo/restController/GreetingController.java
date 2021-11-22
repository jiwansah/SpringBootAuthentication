package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitybean.Greeting;
import com.example.demo.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;
	
	
	@GetMapping("/getmessage")
	public ResponseEntity<List<Greeting>> getMessage() {
		//Greeting greeting =  new Greeting(1, "Welcome to the Spring Boot API");
		List<Greeting> greetingList = greetingService.getAllGreeting();
		return new ResponseEntity<List<Greeting>>(greetingList, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<Greeting> getDefaultMessage() {
		Greeting greeting = new Greeting(1, "Welcome to the Spring Boot World");
		Greeting saveData =  greetingService.saveGreeting(greeting);
		return new ResponseEntity<Greeting>(saveData, HttpStatus.OK);
	}
}
