package com.hcl.surabirestaurant.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.surabirestaurant.entity.UserDetails;
import com.hcl.surabirestaurant.repository.IUserRepository;
import com.hcl.surabirestaurant.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userrepository;
	
	public void addUser(UserDetails userdetails)	// method to save user details in database
	{
		userrepository.save(userdetails);
	}
	
	public UserDetails findUser(String username) {	// method to return user details based on username passed

		return userrepository.findByUsername(username);
	}
	
	public UserDetails findUser(String username, String password) {	// method to return user details based on username and password passed

		return userrepository.findByUsernameAndPassword(username, password);
	}

	public void deleteUser(String username) {	// method to delete user details based on username passed
		
		userrepository.deleteById(username);
	}

	public List<UserDetails> findAllUsers() {	// method to return list of all user details

		return userrepository.findAll();
	}
	
}
