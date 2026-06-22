package com.example.QuickBite.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuickBite.model.FoodItem;


public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {

	}

