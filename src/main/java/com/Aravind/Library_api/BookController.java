package com.Aravind.Library_api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Enumerations.CategoriesEnum;
import project.Book;

@RestController
public class BookController {
	@RequestMapping(path = "/api/v1/createBook")
	@PostMapping
	public ResponseEntity<String> getBooks(@RequestBody Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String author = (String) requestBody.get("author");
		String category = (String) requestBody.get("category");
		String roleOfPersonEntering = (String) requestBody.get("role");
		
		if(roleOfPersonEntering.equals("LIBRARIN")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not an admin mate");
		}
		new Book(name, author, CategoriesEnum.valueOf(category));
		return ResponseEntity.status(HttpStatus.CREATED).body("New book "+name+"added!");
	}
}
