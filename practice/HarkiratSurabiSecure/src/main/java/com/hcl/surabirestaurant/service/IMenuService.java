package com.hcl.surabirestaurant.service;

import java.util.List;

import com.hcl.surabirestaurant.entity.MenuDetails;

public interface IMenuService {

	public MenuDetails findFoodItem(int foodId);	// method to return menu details based on food id passed

	public void addFoodItem(MenuDetails menudetails);	// method to add menu details

	public void deleteMenuItem(int foodId);		// method to delete food item based on food id passed

	public List<MenuDetails> findAllMenuItems();	// method to return all the menu items

	public MenuDetails findPriceOfFood(int foodId);		// method to return menudetails based on food id passes

}
