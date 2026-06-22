package com.example.QuickBite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuickBite.model.*;


public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {
    List<FoodOrder> findByDeliveryPartnerId(int id);
}

	
