package com.hcl.surabirestaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabirestaurant.entity.UserDetails;
import com.hcl.surabirestaurant.service.IUserService;

@RestController
@RequestMapping("/UserCRUD")
@CrossOrigin
public class AdminUserCRUDController {

	@Autowired
	IUserService userservice;
	
	@PostMapping("/adduserdetails")	// method to add a user in database
	public String addUserDetails(@RequestBody UserDetails userdetails) {
		
		System.out.println("I am inside addUserDetails()");

		System.out.println("User Details fetched : " + userdetails.getUsername() + "  " + userdetails.getFullname() + "  "
				+ userdetails.getEmail() + "  " + userdetails.getPassword() + "  " + userdetails.getPhone() + "  " + userdetails.getRole());
		
		UserDetails userCheck = userservice.findUser(userdetails.getUsername()); // checking first if username entered already exits in database or not
		
		if(userCheck == null)
		{
			if(userdetails.getRole().equals("admin") || userdetails.getRole().equals("customer"))	// if role is admin or customer, then only record will be saved
			{
				userservice.addUser(userdetails);		// passing userdetails object to addUser method of IUserService interface

				return "User Added Successfully !!!\n\n"	// returning the success message and user details
						+ "Username : " + userdetails.getUsername()
						+ "\nPassword : " + userdetails.getPassword()
						+ "\nFull Name : " + userdetails.getFullname()
						+ "\nEmail : " + userdetails.getEmail()
						+ "\nPhone : " + userdetails.getPhone()
						+ "\nRole : " + userdetails.getRole();
			}
			else
			{
				return "Invalid Role : "+userdetails.getRole();	// if role entered by user is not admin/customer, then it will return this
			}
			
		}
		else
		{
			return "User Already Present";	// if user already present in database, then method will return this message
		}
		
	}
	
	@GetMapping("/deleteuser/{username}")	// method to delete user from database
	public String deleteUser(String username) {

		System.out.println("I am inside deleteUser() and username is " + username);
		
		UserDetails userStatus = userservice.findUser(username); // checking first if username entered already exits in database or not
		
		if(userStatus != null) 
		{
			userservice.deleteUser(username);		// passing username to deleteUser method of IUserService interface
			
			return "User Deleted Successfully!!!";	// returning the success message
		}
		else
		{
			return "User not Found !!!"; // return this message, if user not found in database
		}

	}
	
	@PostMapping("/updateuserdetails/{username}")	// method to update user details in database
	public String updateUserDetails(@RequestBody UserDetails userdetails)
	{
		
		System.out.println("I am inside updateUserDetails");
		
		System.out.println("User Details fetched : " + userdetails.getUsername() + "  " + userdetails.getFullname() + "  "
				+ userdetails.getEmail() + "  " + userdetails.getPassword() + "  " + userdetails.getPhone() + "  " + userdetails.getRole());

		UserDetails userCheck = userservice.findUser(userdetails.getUsername());	// checking if details entered by user exists in database or not
		
		if(userCheck != null)
		{
			userservice.addUser(userdetails);		// if found user in the database based on the credentials given, then update

			return "User Updated Successfully !!!\n\n"	// returning the success message and user details
					+ "Username : " + userdetails.getUsername()
					+ "\nPassword : " + userdetails.getPassword()
					+ "\nFull Name : " + userdetails.getFullname()
					+ "\nEmail : " + userdetails.getEmail()
					+ "\nPhone : " + userdetails.getPhone()
					+ "\nRole : " + userdetails.getRole();

		}
		else
		{
			return "User Not found";	// if user not found in database, then method will return this message
		}
		
	}
	
	@GetMapping("/printallusers")	// method to print all users present in database
	public List<UserDetails> printAllUsers()
	{
		System.out.println("I am inside printAllUsers()");

		List<UserDetails> users = userservice.findAllUsers();	// this list will store all the users fetched from database

		for (UserDetails user : users) 
		{
			System.out.println(user.getUsername() + "  " + user.getFullname() + "  "
					+ user.getEmail() + "  " + user.getPassword() + "  " + user.getPhone() + "  " + user.getRole());
		}

		return users;	// returning the users fetched
	}
	
}
