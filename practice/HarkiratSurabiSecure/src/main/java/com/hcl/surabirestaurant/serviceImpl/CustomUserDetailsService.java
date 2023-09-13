package com.hcl.surabirestaurant.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.surabirestaurant.repository.IUserRepository;
import com.hcl.surabirestaurant.to.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUserRepository userrepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		System.out.println("I am inside loadUserByUsername");
		
		com.hcl.surabirestaurant.entity.UserDetails user = null;
		
		Optional<com.hcl.surabirestaurant.entity.UserDetails> optional = userrepository.findById(username);
		
		if(optional.isPresent())
		{
			user = optional.get();
		}
		
		return new CustomUserDetails(user);
	}

}
