package com.hcl.surabirestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.surabirestaurant.entity.MenuDetails;

@Repository
public interface IMenuRepository extends JpaRepository<MenuDetails, Integer> {

	MenuDetails findByFoodId(int foodId);	// Method to find Food Item based on food Id
	
}
