package com.hcl.surabirestaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabirestaurant.entity.MenuDetails;
import com.hcl.surabirestaurant.entity.OrderDetails;
import com.hcl.surabirestaurant.entity.UserDetails;
import com.hcl.surabirestaurant.service.IMenuService;
import com.hcl.surabirestaurant.service.IOrderService;
import com.hcl.surabirestaurant.service.IUserService;
import com.hcl.surabirestaurant.to.CustomerOrderTo;

@RestController
@RequestMapping("/CustomerOrder")
@CrossOrigin
public class CustomerOrderController {
	
	@Autowired
	IUserService userservice;	// Object of IUserService interface created

	@Autowired
	IMenuService menuservice;	// Object of IMenuService interface created
	
	@Autowired
	IOrderService orderservice;	// Object of IOrderService interface created
	
	@GetMapping("/printmenuitems")	// method to print all food items present in database
	public List<MenuDetails> printMenuItems()
	{
		System.out.println("I am inside printMenuItems()");

		List<MenuDetails> foodItems = menuservice.findAllMenuItems();	// this list will store all the food items fetched from database

		for (MenuDetails foodItem : foodItems) 
		{
			System.out.println(foodItem.getFoodId() + "  " + foodItem.getFoodName() + "  "
					+ foodItem.getPrice());
		}

		return foodItems;	// returning the food Items fetched
	}
	
	@PostMapping("/customerorderfood")	// method to process orderdetails given by customer
	public String customerOrderFood(@RequestBody List<CustomerOrderTo> orderdetails)
	{
		System.out.println("I am inside customerOrderFood()");
		
		for(CustomerOrderTo orderDetail : orderdetails)	// iterating through the order details given by user
		{
			UserDetails customerCheck = userservice.findUser(orderDetail.getUsername());	// checking if username is valid or not
			
			MenuDetails foodCheck = menuservice.findFoodItem(orderDetail.getFoodId());		// checking if foodId entered is valid or not
			
			if(customerCheck == null)
			{
				return "Customer Not Found !!!";	// return this message if customer not found
			}
			
			if(foodCheck == null)
			{
				return "Food Item not Found !!!";	// return this message if food item not found
			}
		}
		
		OrderDetails ordercheck = orderservice.findLastOrder();		// this object will store the last record of order table
		
		System.out.println(ordercheck.getOrderId());
		
		int generatedOrderId = ordercheck.getOrderId();		// this variable will store the orderId of Last order fetched from the database
		
		++generatedOrderId;		// incrementing the orderId fetched to add this in current order
		
		for(CustomerOrderTo orderDetail : orderdetails)		// iterating through the order details given by user
		{	
			MenuDetails menuDetail = menuservice.findPriceOfFood(orderDetail.getFoodId());	// to find the price of foodItem based on foodId entered
			
			OrderDetails orderFood = new OrderDetails();	// object of OrderDetails created and setting the respective values
			
			orderFood.setUsername(orderDetail.getUsername());
			
			orderFood.setFoodId(orderDetail.getFoodId());
			
			orderFood.setQuantity(orderDetail.getQuantity());
			
			orderFood.setPrice(menuDetail.getPrice());
			
			orderFood.setOrderId(generatedOrderId);
			
			orderFood.setOrderDate(java.time.LocalDate.now());
			
			orderservice.addOrder(orderFood);	// to save the order in database
		}
		
		return "Order Placed Successfully !!!";	// returning the success message
		
	}
	
	@PostMapping("/customerfetchbilldetails")	// method to fetch the bill details based on orderId
	public List<OrderDetails> customerFetchBillDetails(int orderId)
	{
		System.out.println("I am inside customerFetchBillDetails");
		
		List<OrderDetails> orderDetails = orderservice.findCustomerBill(orderId);	// this list will store all the orders fetched based on the orderId passed
		
		return orderDetails;	// returning the orderDetails
	}
	
	@PostMapping("/customerfetchbillamount")	// method to fetch the total bill amount based on orderId
	public String customerFetchBillAmount(int orderId)
	{
		System.out.println("I am inside customerFetchBillAmount");
	
		Double billAmount = orderservice.findCustomerBillAmount(orderId);	// this variable will store the billamount fetched based on the orderId passed
		 
		return "Total Bill Amount for Order Id : " + orderId + " is : " + billAmount;	// returning the total bill amount
	}
	
}
