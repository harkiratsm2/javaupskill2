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
import com.hcl.surabirestaurant.service.IMenuService;

@RestController
@RequestMapping("/MenuCRUD")
@CrossOrigin
public class AdminMenuCRUDController {	// RestController class to handle Food Menu CRUD Operation for admin user

	@Autowired
	IMenuService menuservice;	// Object of IMenuService interface created
	
	@PostMapping("/addmenudetails")	// method to save food item details in database
	public String addMenuDetails(@RequestBody MenuDetails menudetails) {
		
		System.out.println("I am inside addMenuDetails()");

		System.out.println("Menu Details fetched : " + menudetails.getFoodId() + "  " + menudetails.getFoodName() + "  "
				+ menudetails.getPrice());
		
		MenuDetails menuCheck = menuservice.findFoodItem(menudetails.getFoodId()); // checking first if food item entered already exits in database or not
		
		if(menuCheck == null)
		{
			menuservice.addFoodItem(menudetails);		// passing menudetails object to addFoodItem method of IMenuService interface

			return "Menu Item Added Successfully !!!\n\n"	// returning the success message and menu details
					+ "Food Id : " + menudetails.getFoodId()
					+ "\nFood Name : "+menudetails.getFoodName()
					+ "\nPrice : "+menudetails.getPrice();
		}
		else
		{
			return "Menu Item Already Present";	// if food item already present in database, then method will return this message
		}
		
	}
	
	@GetMapping("/deleteMenuitem/{foodId}")	// method to delete food item details in database
	public String deleteMenuItem(int foodId) {

		System.out.println("I am inside deleteMenuItem() and foodId is " + foodId);
		
		MenuDetails menuStatus = menuservice.findFoodItem(foodId); // checking first if food item entered already exits in database or not
		
		if(menuStatus != null) 
		{
			menuservice.deleteMenuItem(foodId);		// passing foodId to deleteMenuItem method of IMenuService interface
			
			return "Menu Item Deleted Successfully!!!";	// returning the success message
		}
		else
		{
			return "Menu Item not Found !!!";	// return this message, if food id entered is not found in database
		}

	}
	
	@PostMapping("/updatemenudetails")	// method to update food item details in database
	public String updateMenuDetails(@RequestBody MenuDetails menudetails)
	{
		
		System.out.println("I am inside updateMenuDetails");
		
		System.out.println("Menu Details fetched : " + menudetails.getFoodId() + "  " + menudetails.getFoodName() + "  "
				+ menudetails.getPrice());
		
		MenuDetails menuCheck = menuservice.findFoodItem(menudetails.getFoodId()); // checking first if food item entered already exits in database or not
		
		if(menuCheck != null)
		{
			menuservice.addFoodItem(menudetails);		// passing menudetails object to addFoodItem method of IMenuService interface

			return "Menu Item Updated Successfully !!!\n\n"	// returning the success message and menu details
					+ "Food Id : " + menudetails.getFoodId()
					+ "\nFood Name : "+menudetails.getFoodName()
					+ "\nPrice : "+menudetails.getPrice();
		}
		else
		{
			return "Menu Item Not Found !!!";	// return this message, if food id entered is not found in database
		}
		
	}
	
	@GetMapping("/printallmenuitems")	// method to print all food items present in database
	public List<MenuDetails> printAllMenuItems()
	{
		System.out.println("I am inside printAllMenuItems()");

		List<MenuDetails> foodItems = menuservice.findAllMenuItems();	// this list will store all the food items fetched from database

		for (MenuDetails foodItem : foodItems) 
		{
			System.out.println(foodItem.getFoodId() + "  " + foodItem.getFoodName() + "  "
					+ foodItem.getPrice());
		}

		return foodItems;	// returning the food Items fetched
	}
	
}
