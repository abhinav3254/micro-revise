package com.rest;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Book;


/**
 * RESTful API for managing books.
 */
@RequestMapping("/get")
public interface BookRest {
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> addBook();

}
