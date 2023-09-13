package com.hcl.surabirestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabirestaurant.service.IUserService;
import com.hcl.surabirestaurant.to.UserLoginTo;
import com.hcl.surabirestaurant.entity.UserDetails;

@RestController
@CrossOrigin
public class AdminLoginSignUpController {	// RestController class to handle Admin LoginIn and Sign-Up operation
	
	@Autowired
	IUserService userservice;		// Object of IUserService interface created
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/adminuserregistration")	// method to save admin user registration details in database
	public String adminUserRegistration(UserDetails userdetails) {

		System.out.println("I am inside adminUserRegistration()");

		System.out.println("User Details fetched : " + userdetails.getUsername() + "  " + userdetails.getPassword()
				+ "  " + userdetails.getFullname() + "  " + userdetails.getEmail() + "  " + userdetails.getPhone()+"  "+userdetails.getRole());
		
		UserDetails userCheck = userservice.findUser(userdetails.getUsername()); // checking first if username entered already exits in database or not
		
		if(userCheck == null)
		{
			if(userdetails.getRole().equals("admin"))	// if role is admin, then only record will be saved
			{
				userdetails.setRole("ROLE_ADMIN");
				
				String encodedPassword = passwordEncoder.encode(userdetails.getPassword());
				
				userdetails.setPassword(encodedPassword);
				
				userservice.addUser(userdetails);		// passing userdetails object to addUser method of IUserService interface
				
				return "Admin User Registered Successfully !!!\n\n"	// returning the success message and user details
						+ "Username : " + userdetails.getUsername()
						+ "\nPassword : " + userdetails.getPassword()
						+ "\nFull Name : " + userdetails.getFullname()
						+ "\nEmail : " + userdetails.getEmail()
						+ "\nPhone : " + userdetails.getPhone()
						+ "\nRole : " + userdetails.getRole();
			}
			else
			{
				return "Role is Not Admin. User not Added !!!";		// if role entered by user is not admin, then it will return this
			}
			
		}
		else
		{
			return "User already present";	// if user already present in database, then method will return this message
		}

	}
	
	@PostMapping("/adminuserlogin")		// method to validate admin user credentials
	public String adminUserLogin(@RequestBody UserLoginTo userLogin) {

		System.out.println("I am inside adminUserLogin()");

		UserDetails userdetails = userservice.findUser(userLogin.getUsername(), userLogin.getPassword());	// checking if details entered by user exists in database or not 

		if (userdetails != null) {		// if found user in the database based on the credentials given, then login 

			System.out.println("User Details : " + userdetails.getUsername() + ", " + userdetails.getPassword() + ", " + userdetails.getRole());
			
			if(userLogin.getRole().equals("admin"))
			{
				return "Admin User Logged-In Successfully\n\n"	// return login success message and user details
						+ "Username : " + userdetails.getUsername()
						+ "\nFullname : " + userdetails.getFullname()
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
	
//	@PostMapping("/adminuserlogout")
//	public String adminUserLogout()
//	{
//		return "User Logged out Successfully";
//	}
}
