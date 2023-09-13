package com.hcl.surabirestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.surabirestaurant.entity.UserDetails;

@Repository
public interface IUserRepository extends JpaRepository<UserDetails, String> {
	
	UserDetails findByUsername(String username);	// method to find UserDetails based on username passed to it
	
	UserDetails findByUsernameAndPassword(String username, String password);	// method to find UserDetails based on username and password passed to it

}
