package com.hcl.doconnect.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.User;
import com.hcl.doconnect.repository.IUserRepository;
import com.hcl.doconnect.service.IUserService;
import com.hcl.doconnect.to.UserTO;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository iUserRepository;
	
	public String addUserService(UserTO userTO) {
		
		String status = "User Already Exists";
		
		User user = new User(0, userTO.getUsername(), userTO.getPassword(), userTO.getFullname(), userTO.getEmail(), userTO.getPhone(), userTO.getRole());
		
		User userCheck = iUserRepository.findByUsername(userTO.getUsername());
		
		if(userCheck == null)
		{
			iUserRepository.save(user);
			
			status = "User Added Successfully";
		}

		return status;
	}

	public String updateUserService(User user) {
		
		String status = "User Not Found";
		
		User userCheck = iUserRepository.findById(user.getId());
		
		if(userCheck != null)
		{
			iUserRepository.save(user);
			
			status = "User Updated Successfully";
		}
		
		return status;
	}
	
	public String deleteUserService(int userId) {

		String status = "User Not Found";
		
		User userCheck = iUserRepository.findById(userId);
		
		if(userCheck != null)
		{
			iUserRepository.deleteById(userId);
			
			status = "User Deleted Successfully";
		}
		
		return status;
	}

	public List<User> getAllUsersService() {

		return iUserRepository.findAll();
	}

	public User findUserService(String username, String password) {

		User userCheck = iUserRepository.findByUsernameAndPassword(username, password);
		
		return userCheck;	
	}


	public User findUserByUserIdService(int userId) {
			
		User user = iUserRepository.findById(userId);
		
		return user;
	}

	public String partialUpdatePhone(int userId, String phone) {
		
		String updatePhoneStatus = "User not Found";

		User user = iUserRepository.findById(userId);
		
		if(user != null)
		{
			user.setPhone(phone);
			iUserRepository.save(user);
			
			updatePhoneStatus = "Phone Number Updated Successfully";
		}
		
		return updatePhoneStatus;
	}

}
