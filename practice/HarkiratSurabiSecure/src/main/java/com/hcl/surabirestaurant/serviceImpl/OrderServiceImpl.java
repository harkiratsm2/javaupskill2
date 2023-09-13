package com.hcl.surabirestaurant.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.surabirestaurant.entity.OrderDetails;
import com.hcl.surabirestaurant.repository.IOrderRepository;
import com.hcl.surabirestaurant.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderrepository;
	
	public void addOrder(OrderDetails orderDetail) {	// method to add order details
		
		orderrepository.save(orderDetail);
		
	}

	public List<OrderDetails> findAllOrders() {	// method to return all the order details

		return orderrepository.findAll();
	}

	public List<OrderDetails> findOrdersByDate(LocalDate startDate, LocalDate endDate) {	// method to return all the order details based on dates provided

		return orderrepository.findByOrderDateBetween(startDate, endDate);
	}

	public List<OrderDetails> findCustomerBill(int orderId) {	// method to return customer bill amount based on order id

		return orderrepository.findByOrderId(orderId);
	}

	public OrderDetails findLastOrder() {	// method to return Order details of last order

		return orderrepository.findTopByOrderBySerialNoDesc();
	}

	public Double findCustomerBillAmount(int orderId) {	// method to return total bill amount fetched based on order id

		return orderrepository.findCustomerBillAmount(orderId);
	}

	public Double findCustomerBillAmountOfToday(LocalDate currentDate) {	// method to return total bill amount fetched based on order date

		return orderrepository.findCustomerBillAmountOfToday(currentDate);
	}

	public Double findCustomerBillAmountOfCurrentMonth(LocalDate startDate, LocalDate endDate) {	// method to return total bill amount fetched based on order dates

		return orderrepository.findCustomerBillAmountOfCurrentMonth(startDate, endDate);
	}

	public Double findCustomerBillAllAmount() {	// method to return total bill amount

		return orderrepository.findCustomerBillAllAmount();
	}
	
}
