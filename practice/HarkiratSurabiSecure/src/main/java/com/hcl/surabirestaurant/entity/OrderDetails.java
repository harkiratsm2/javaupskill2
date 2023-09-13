package com.hcl.surabirestaurant.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SurabiOrder")
public class OrderDetails {	// OrderDetails Entity Class to store the Order Details

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;
	private int orderId;
	private String username;
	private int foodId;
	private int quantity;
	private int price;
	private LocalDate orderDate;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int serialNo, int orderId, String username, int foodId, int quantity, int price,
			LocalDate orderDate) {
		super();
		this.serialNo = serialNo;
		this.orderId = orderId;
		this.username = username;
		this.foodId = foodId;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
}
