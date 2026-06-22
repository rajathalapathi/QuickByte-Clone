package com.example.QuickBite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuickBite.dao.FoodItemRepo;
import com.example.QuickBite.dao.FoodOrderRepo;
import com.example.QuickBite.dao.RestaurantRepo;
import com.example.QuickBite.dao.UserRepo;
import com.example.QuickBite.model.FoodItem;
import com.example.QuickBite.model.FoodOrder;
import com.example.QuickBite.model.OrderStatus;
import com.example.QuickBite.model.Restaurant;
import com.example.QuickBite.model.User;

@RequestMapping("/admin")
@RestController

public class AdminController {
    @Autowired
	RestaurantRepo rr;
    @Autowired
	UserRepo ur;
    @Autowired
	FoodItemRepo fir;
    @Autowired
	FoodOrderRepo foor;
        
    @PostMapping("/restaurant")
    public Restaurant get1(@RequestBody Restaurant r) {
        return rr.save(r);
    }
    
    @PostMapping("/food")
    public FoodItem get2(@RequestBody FoodItem f) {
        return fir.save(f);
    }
    
    @PutMapping("/assign/{orderId}/{partnerId}")
    public FoodOrder assignDelivery(
            @PathVariable int orderId,
            @PathVariable int partnerId) {

        FoodOrder order = foor.findById(orderId).get();
        User partner = ur.findById(partnerId).get();

        order.setDeliveryPartner(partner);
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
        return foor.save(order);
    }



}