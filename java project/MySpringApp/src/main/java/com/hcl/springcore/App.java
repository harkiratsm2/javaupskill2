package com.hcl.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		System.err.println("Setter Injection");

		Student student1 = (Student) context.getBean("student1");

		System.out.println(student1.getRollNo() + "  " + student1.getStudentName() + "  " + student1.getAddress());

		Student student2 = (Student) context.getBean("student2");

		System.out.println(student2.getRollNo() + "  " + student2.getStudentName() + "  " + student2.getAddress());

		System.err.println("Constructor Injection");

		Student student3 = (Student) context.getBean("student3");

		System.out.println(student3.getRollNo() + "  " + student3.getStudentName() + "  " + student3.getAddress());

	}
}
