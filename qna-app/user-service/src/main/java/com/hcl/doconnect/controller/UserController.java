package com.hcl.doconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.doconnect.entity.User;
import com.hcl.doconnect.service.IUserService;
import com.hcl.doconnect.to.UserTO;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserTO userTO)
	{
		String addStatus = iUserService.addUserService(userTO);
		
		return addStatus;
				
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User user)
	{
		String updateStatus = iUserService.updateUserService(user);
		
		return updateStatus;
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable int userId)
	{
		String deleteStatus = iUserService.deleteUserService(userId);
		
		return deleteStatus;
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		List<User> users = iUserService.getAllUsersService();
		
		return users;
	}
	
	@GetMapping("/findUser/{username}/{password}")
	public User findUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password)
	{
		User user = iUserService.findUserService(username, password);
		
		return user;
	}
	
	@GetMapping("/findById/{userId}")
	public User findUserByUserId(@PathVariable int userId)
	{
		User user = iUserService.findUserByUserIdService(userId);
		
		return user;
	}
	
	@PatchMapping("/partialUpdate/{userId}/{phone}")
	public String updateUserPhone(@PathVariable int userId, @PathVariable String phone)
	{
		String partialUpdateStatus = iUserService.partialUpdatePhone(userId, phone);
		
		return partialUpdateStatus;
	}

}
