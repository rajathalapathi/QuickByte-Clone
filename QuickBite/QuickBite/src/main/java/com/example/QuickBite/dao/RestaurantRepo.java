package com.example.QuickBite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuickBite.model.FoodItem;
import com.example.QuickBite.model.Restaurant;


public interface RestaurantRepo  extends JpaRepository<Restaurant,Integer> {

}


	

	