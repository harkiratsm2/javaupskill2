package com.hcl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.to.Student;

@Service
public class StudentService {
	
	List<Student> students = new ArrayList<Student>();
	
	public StudentService()
	{
		System.out.println("I am inside StudentService() constructor");
		
		Student student1 = new Student("har@123","123","Harkirat Singh",null);
		Student student2 = new Student("omk@123", "111", "Omkar", null);
		
		students.add(student1);		 students.add(student2);
	}
	
	public Student getStudentByUsername(String username)
	{
		for(Student student : students)
		{
			if(username.equals(student.getUsername()))
			{
				return student;
			}
		}
		return null;
	}

}
