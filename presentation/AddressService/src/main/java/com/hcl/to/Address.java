package com.hcl.to;

public class Address {
	
	private String addressId;
	private String streetName;
	private String city;
	private String state;
	private String username;
	
	public Address() {
		super();
	}

	public Address(String addressId, String streetName, String city, String state, String username) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.username = username;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
