package com.hcl.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.doconnect.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);
	
	User findById(int id);

}
