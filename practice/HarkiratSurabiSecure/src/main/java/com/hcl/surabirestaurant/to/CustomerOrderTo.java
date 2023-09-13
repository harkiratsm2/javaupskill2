package com.hcl.surabirestaurant.to;

public class CustomerOrderTo {	// TO class to get order details provided by customer

	private String username;
	private int foodId;
	private int quantity;
	
	public CustomerOrderTo() {
		super();
	}

	public CustomerOrderTo(String username, int foodId, int quantity) {
		super();
		this.username = username;
		this.foodId = foodId;
		this.quantity = quantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
