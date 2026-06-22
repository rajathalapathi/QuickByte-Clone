package com.example.QuickBite.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuickBite.dao.*;
import com.example.QuickBite.model.*;


@RestController
public class CustomerController {

    
    @Autowired
	UserRepo ur;
    @Autowired
	FoodItemRepo fir;
    @Autowired
	FoodOrderRepo foor;
    @GetMapping("/foods")
    public List<FoodItem> viewFoods() {
        return fir.findAll();
    }
    @PostMapping("/order/{customerId}")
    public FoodOrder placeOrder(
            @PathVariable int customerId,
            @RequestBody List<Integer> foodIds) {

        FoodOrder order = new FoodOrder();
        order.setCustomer(ur.findById(customerId).get());
        order.setItems(fir.findAllById(foodIds));
        order.setStatus(OrderStatus.PLACED);

        return foor.save(order);
    }

    
	
}