package com.example.QuickBite.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuickBite.dao.UserRepo;
import com.example.QuickBite.model.User;
@RestController

public class AuthController {
	
	
	@Autowired
	UserRepo r;
	@Autowired
	PasswordEncoder e;
	
	
	  @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return r.findAll();
	    }
	
	@PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(e.encode(user.getPassword()));
        return r.save(user);
    }

	
}
	


