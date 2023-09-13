package com.hcl.surabirestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabirestaurant.entity.UserDetails;
import com.hcl.surabirestaurant.service.IUserService;
import com.hcl.surabirestaurant.to.UserLoginTo;

@RestController
@CrossOrigin
public class CustomerLoginSignUpController {	// RestController class to handle Customer LoginIn and Sign-Up operation

	@Autowired
	IUserService userservice;		// Object of IUserService interface created
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/customerregistration")	// method to save customer user registration details in database
	public String customerRegistration(UserDetails userdetails) {

		System.out.println("I am inside customerRegistration()");

		System.out.println("User Details fetched : " + userdetails.getUsername() + "  " + userdetails.getPassword()
				+ "  " + userdetails.getFullname() + "  " + userdetails.getEmail() + "  " + userdetails.getPhone()+"  "+userdetails.getRole());
		
		UserDetails userCheck = userservice.findUser(userdetails.getUsername()); // checking first if username entered already exits in database or not
		
		if(userCheck == null)
		{
			if(userdetails.getRole().equals("customer"))	// if role is customer, then only record will be saved
			{
				userdetails.setRole("ROLE_CUSTOMER");
				
				String encodedPassword = passwordEncoder.encode(userdetails.getPassword());
				
				userdetails.setPassword(encodedPassword);
				
				userservice.addUser(userdetails);		// passing userdetails object to addUser method of IUserService interface
				
				return "Customer Registered Successfully !!!\n\n"	// returning the success message and user details
						+ "Username : " + userdetails.getUsername()
						+ "\nPassword : " + userdetails.getPassword()
						+ "\nFull Name : " + userdetails.getFullname()
						+ "\nEmail : " + userdetails.getEmail()
						+ "\nPhone : " + userdetails.getPhone()
						+ "\nRole : " + userdetails.getRole();
			}
			else
			{
				return "Role is not Customer. User Not Added !!!";		// if role entered by user is not customer, then it will return this
			}
			
		}
		else
		{
			return "User already present";	// if user already present in database, then method will return this message
		}

	}
	
	@PostMapping("/customerlogin")		// method to validate customer user credentials
	public String customerLogin(@RequestBody UserLoginTo userLogin) {

		System.out.println("I am inside customerLogin()");

		UserDetails userdetails = userservice.findUser(userLogin.getUsername(), userLogin.getPassword());	// checking if details entered by user exists in database or not

		if (userdetails != null) {		// if found user in the database based on the credentials given, then login

			System.out.println("User Details : " + userdetails.getUsername() + ", " + userdetails.getPassword() + ", " + userdetails.getRole());
			
			if(userLogin.getRole().equals("customer"))
			{
				
				return "Customer Logged-In Successfully\n\n"	// return login success message and user details
						+ "Username : " + userdetails.getUsername()
						+ "\nFull Name : " + userdetails.getFullname()
						+ "\nRole : " + userdetails.getRole()
						+ "\nE-mail : " + userdetails.getEmail()
						+ "\nPhone : " + userdetails.getPhone();
			}
			else
			{
				return "Invalid Role : " + userLogin.getRole();	// return this message if role is invalid
			}
			
			
		} 
		else 
		{
			return "Invalid Username/Password";		// return this message if credentials are incorrect
		}

	}
	
	@GetMapping("/customerlogout")
	public String customerLogout()
	{
		return "Customer Logged out Successfully";
	}
	
}
