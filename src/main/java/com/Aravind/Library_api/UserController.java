package com.Aravind.Library_api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Enumerations.UserTypes;
import project.User;

@RestController
public class UserController {
	
	@GetMapping
	@RequestMapping(path = "/api/v1/getUsers")
	public List<User> returnUser() {
		return User.getUsers();
	}
	
	@PostMapping
	@ResponseStatus
	@RequestMapping(path = "/api/v1/createUser")
	public String createUser(@RequestBody Map<String, Object> requestBody ) {
		String name = (String) requestBody.get("name");
		int age = (int) requestBody.get("age");
		String userType = (String) requestBody.get("userType");
		
		new User(name, age, UserTypes.valueOf(userType));
		return "Created new Account for " + name; 
	}
}
