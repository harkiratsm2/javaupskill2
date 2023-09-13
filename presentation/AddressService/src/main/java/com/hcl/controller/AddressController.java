package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.AddressService;
import com.hcl.to.Address;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/getAddress/{username}")
	public Address getAddress(@PathVariable String username)
	{
		System.out.println("I am inside getAddress() and username is : "+username);
		
		Address address = addressService.getAddressByUsername(username);
		
		return address;
		
	}

}
