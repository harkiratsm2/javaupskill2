package com.hcl.to;

public class Address {
	
	private String addressId;
	private String streetName;
	private String city;
	private String state;
	
	public Address() {
		super();
	}

	public Address(String addressId, String streetName, String city, String state) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
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

}
