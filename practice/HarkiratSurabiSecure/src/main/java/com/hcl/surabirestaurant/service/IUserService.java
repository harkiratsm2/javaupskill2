package com.hcl.surabirestaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.surabirestaurant.entity.UserDetails;

@Service
public interface IUserService {

	public void addUser(UserDetails userdetails);	// method to save user details in database
	
	public UserDetails findUser(String username);	// method to return user details based on username passed
	
	public UserDetails findUser(String username, String password);	// method to return user details based on username and password passed

	public void deleteUser(String username);	// method to delete user details based on username passed

	public List<UserDetails> findAllUsers();	// method to return list of all user details
	
}
