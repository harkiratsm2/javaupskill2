package com.hcl.surabirestaurant.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.surabirestaurant.entity.MenuDetails;
import com.hcl.surabirestaurant.repository.IMenuRepository;
import com.hcl.surabirestaurant.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	IMenuRepository menurepository;
	
	public MenuDetails findFoodItem(int foodId) {	// method to return menu details based on food id passed

		return menurepository.findByFoodId(foodId);
	}

	public void addFoodItem(MenuDetails menudetails) {	// method to add menu details
		
		menurepository.save(menudetails);
	}

	public void deleteMenuItem(int foodId) {		// method to delete food item based on food id passed

		menurepository.deleteById(foodId);
		
	}

	public List<MenuDetails> findAllMenuItems() {	// method to return all the menu items
		
		return menurepository.findAll();
	}
	
	public MenuDetails findPriceOfFood(int foodId) {		// method to return menudetails based on food id passes

		return menurepository.findByFoodId(foodId);
	}

}
