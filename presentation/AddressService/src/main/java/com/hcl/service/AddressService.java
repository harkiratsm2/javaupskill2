package com.hcl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.to.Address;

@Service
public class AddressService {
	
List<Address> addresses = new ArrayList<Address>();
	
	public AddressService()
	{
		System.out.println("I am inside AddressService() constructor");
		
		Address address1 = new Address("A_001", "abc road", "Ludhiana", "Punjab", "har@123");
		Address address2 = new Address("A_002", "xyz road", "Ambala", "Haryana", "omk@123");
		
		addresses.add(address1);		 addresses.add(address2);
	}
	
	public Address getAddressByUsername(String username)
	{
		for(Address address : addresses)
		{
			if(username.equals(address.getUsername()))
			{
				return address;
			}
		}
		return null;
	}

}
