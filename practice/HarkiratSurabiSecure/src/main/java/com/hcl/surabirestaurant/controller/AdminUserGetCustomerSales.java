package com.hcl.surabirestaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabirestaurant.entity.OrderDetails;
import com.hcl.surabirestaurant.service.IOrderService;

@RestController
@RequestMapping("/CustomerSales")
@CrossOrigin
public class AdminUserGetCustomerSales {	// RestController class to handle Admin Customer Sales operation

	@Autowired
	IOrderService orderservice;
	
	@PostMapping("/getordersoftoday")	// method to fetch order details of today's date
	public List<OrderDetails> getOrdersOfToday()
	{
		System.out.println("I am inside getOrdersofToday");
		
		List<OrderDetails> orderDetails = orderservice.findOrdersByDate(java.time.LocalDate.now(), java.time.LocalDate.now());	// this list will store the order details of today's orders
		
		for(OrderDetails orderDetail : orderDetails)
		{
			System.out.println(orderDetail.getSerialNo() + "  " + orderDetail.getFoodId() + "  " + orderDetail.getOrderDate()
			+ "  " + orderDetail.getOrderId() + "  " + orderDetail.getQuantity() + "  " + orderDetail.getUsername());
		}
		
		return orderDetails;	// returning the order details fetched
	}
	
	@GetMapping("/getordersofmonth")	// method to fetch order details of current month
	public List<OrderDetails> getOrdersOfMonth()
	{
		System.out.println("I am inside getOrdersOfMonth");
		
		List<OrderDetails> orderDetails = orderservice.findOrdersByDate(java.time.LocalDate.now().withDayOfMonth(1), java.time.LocalDate.now());	// this list will store the order details of current month's orders
		
		for(OrderDetails orderDetail : orderDetails)
		{
			System.out.println(orderDetail.getSerialNo() + "  " + orderDetail.getFoodId() + "  " + orderDetail.getOrderDate()
			+ "  " + orderDetail.getOrderId() + "  " + orderDetail.getQuantity() + "  " + orderDetail.getUsername());
		}
		
		return orderDetails;	// returning the order details fetched
	}
	
	@GetMapping("/getallorders")	// method to fetch all order details
	public List<OrderDetails> getAllOrders()
	{
		System.out.println("I am inside getAllOrders");
		
		List<OrderDetails> orderDetails = orderservice.findAllOrders();	// this list will store all the order details
		
		for(OrderDetails orderDetail : orderDetails)
		{
			System.out.println(orderDetail.getSerialNo() + "  " + orderDetail.getFoodId() + "  " + orderDetail.getOrderDate()
			+ "  " + orderDetail.getOrderId() + "  " + orderDetail.getQuantity() + "  " + orderDetail.getUsername());
		}
		
		return orderDetails;	// returning the order details fetched
	}
	
	@GetMapping("/getamountoftodaysorders")	// method to fetch total amount of today's date orders
	public String getAmountOfTodaysOrders()
	{
		System.out.println("I am inside getAmountOfTodaysOrders()");
		
		Double billAmount = orderservice.findCustomerBillAmountOfToday(java.time.LocalDate.now()); // this variable will store the total amount fetched
		
		return "Total Bill Amount for " + java.time.LocalDate.now() + " sales is : " + billAmount;	// returning the total amount fetched
	}
	
	@GetMapping("/getamountofcurrentmonthorders")	// method to fetch total amount of current month's orders
	public String getAmountOfCurrentMonthOrders()
	{
		System.out.println("I am inside getAmountOfCurrentMonthOrders()");
		
		Double billAmount = orderservice.findCustomerBillAmountOfCurrentMonth(java.time.LocalDate.now().withDayOfMonth(1), java.time.LocalDate.now()); // this variable will store the total amount fetched
		
		return "Total Bill Amount for Current Month sales is : " + billAmount;	// returning the total amount fetched
	}
	
	@GetMapping("/getamountofallorders")	// method to fetch total amount of all orders
	public String getAmountOfAllOrders()
	{
		System.out.println("I am inside getAmountOfAllOrders()");
		
		Double billAmount = orderservice.findCustomerBillAllAmount(); // this variable will store the total amount fetched
		
		return "Total Bill Amount for all Orders is : " + billAmount;	// returning the total amount fetched
	}
}
