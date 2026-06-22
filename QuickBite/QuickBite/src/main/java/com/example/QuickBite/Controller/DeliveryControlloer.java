package com.example.QuickBite.Controller;
import com.example.QuickBite.dao.*;
import com.example.QuickBite.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuickBite.dao.FoodItemRepo;
import com.example.QuickBite.dao.FoodOrderRepo;
import com.example.QuickBite.dao.RestaurantRepo;
import com.example.QuickBite.dao.UserRepo;


@RestController
@RequestMapping("/delivery")

public class DeliveryControlloer {
	
	 @Autowired
		FoodOrderRepo foor;
	 @GetMapping("/orders/{partnerId}")
	    public List<FoodOrder> myOrders(@PathVariable int partnerId){
	        return foor.findByDeliveryPartnerId(partnerId);
	    }
	 @PutMapping("/status/{orderId}")
	    public FoodOrder updateStatus(@PathVariable int orderId) {
	        FoodOrder order = foor.findById(orderId).get();
	        order.setStatus(OrderStatus.DELIVERED);
	        return foor.save(order);
	    }
}

