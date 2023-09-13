package com.hcl.surabirestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SurabiMenu")
public class MenuDetails {	// MenuDetails Entity Class to store the Menu Details
	
	@Id
	private int foodId;
	private String foodName;
	private int price;
	
	public MenuDetails() {
		super();
	}

	public MenuDetails(int foodId, String foodName, int price) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
