package com.hcl.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.StudentServiceApplication;
import com.hcl.service.StudentService;
import com.hcl.to.Address;
import com.hcl.to.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger LOG = Logger.getLogger(StudentServiceApplication.class.getName());
	
	@GetMapping("/getStudent/{username}")
	public Student getStudent(@PathVariable String username)
	{
		
		LOG.log(Level.INFO, "Student Service is calling");
		
		System.out.println("I am inside getStudent() and username is : "+username);
		
		Student student = studentService.getStudentByUsername(username);
		
//		Address address = restTemplate.getForObject("http://localhost:8081/getAddress/"+username, Address.class);
		
		Address address = restTemplate.getForObject("http://address-service/address/getAddress/"+username, Address.class);
		
		student.setAddress(address);
		
		return student;
	}

}
