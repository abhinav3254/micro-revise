package com.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Book;

@RequestMapping("/get")
public interface BookController {
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks();
	
}
