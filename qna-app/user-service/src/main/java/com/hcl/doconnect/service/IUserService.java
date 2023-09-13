package com.hcl.doconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.User;
import com.hcl.doconnect.to.UserTO;

@Service
public interface IUserService {

	String addUserService(UserTO userTO);

	String updateUserService(User user);

	String deleteUserService(int userId);

	List<User> getAllUsersService();

	User findUserService(String username, String password);

	User findUserByUserIdService(int userId);

	String partialUpdatePhone(int userId, String phone);

}
