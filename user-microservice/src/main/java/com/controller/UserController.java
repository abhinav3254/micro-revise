package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.Contact;
import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public User getUserId(@PathVariable("userId") Long userId) {
		
		User user = this.userService.getUser(userId);
		
		// http://localhost:9096/contact/user/1
		
		List list =  this.restTemplate.getForObject("http://localhost:9096/contact/user/"+user.getUserId(), List.class);
		
		user.setContacts(list);
		
		return user;
	}
	
}
