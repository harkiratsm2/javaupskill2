package com.hcl.surabirestaurant.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.surabirestaurant.entity.OrderDetails;

@Service
public interface IOrderService {

	public void addOrder(OrderDetails orderDetail);	// method to add order details

	public List<OrderDetails> findAllOrders();	// method to return all the order details

	public List<OrderDetails> findOrdersByDate(LocalDate startDate, LocalDate endDate);	// method to return all the order details based on dates provided

	public List<OrderDetails> findCustomerBill(int orderId);	// method to return customer bill amount based on order id

	public OrderDetails findLastOrder();	// method to return Order details of last order

	public Double findCustomerBillAmount(int orderId);	// method to return total bill amount fetched based on order id

	public Double findCustomerBillAmountOfToday(LocalDate currentDate);	// method to return total bill amount fetched based on order date

	public Double findCustomerBillAmountOfCurrentMonth(LocalDate startDate, LocalDate endDate);	// method to return total bill amount fetched based on order dates

	public Double findCustomerBillAllAmount();	// method to return total bill amount
	
}
