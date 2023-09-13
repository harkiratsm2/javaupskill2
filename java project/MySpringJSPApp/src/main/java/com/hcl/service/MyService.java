package com.hcl.service;

import com.hcl.entity.Student;

public class MyService {
	
	public Student getStudent()
	{
		Student student = new Student(101, "Harkirat Singh", "New Delhi");
		
		return student;
	}

}
