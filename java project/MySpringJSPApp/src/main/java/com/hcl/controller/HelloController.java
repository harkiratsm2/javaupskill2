package com.hcl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.entity.Student;
import com.hcl.service.MyService;

public class HelloController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MyService myService = new MyService();
		
		Student student = myService.getStudent();
		
		System.out.println(student.getRollNo());
		
		request.setAttribute("student", student);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		
		requestDispatcher.forward(request, response);
	}

}
