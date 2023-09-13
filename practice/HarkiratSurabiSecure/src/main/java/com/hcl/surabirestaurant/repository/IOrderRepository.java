package com.hcl.surabirestaurant.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.surabirestaurant.entity.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

	List<OrderDetails> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);	// this list will store the orderDetails based on dates passed to it

	OrderDetails findTopByOrderBySerialNoDesc();	// Method to find the last order in the order table

	List<OrderDetails> findByOrderId(int orderId);	//  this list will store the orderDetails based on the orderId passed to it

	@Query("SELECT SUM(m.price*m.quantity) FROM OrderDetails m WHERE orderId=:orderId")
	Double findCustomerBillAmount(@Param("orderId") int orderId);	// custom query to calculate the customer bill amount based on orderId provided

	@Query("SELECT SUM(m.price*m.quantity) FROM OrderDetails m WHERE orderDate=:orderDate")
	Double findCustomerBillAmountOfToday(@Param("orderDate")LocalDate currentDate);	// custom query to calculate the customer bill amount based on Date provided
	
	@Query("SELECT SUM(m.price*m.quantity) FROM OrderDetails m WHERE orderDate BETWEEN :startDate AND :endDate")
	Double findCustomerBillAmountOfCurrentMonth(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);	// custom query to calculate the customer bill amount based on Dates provided

	@Query("SELECT SUM(m.price*m.quantity) FROM OrderDetails m")
	Double findCustomerBillAllAmount();	// custom query to calculate the customer bill amount of all orders
	
}
