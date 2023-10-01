package com.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Book;

@RequestMapping("/add")
public interface BookController {
	
	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody(required = true) Book book);
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks();
	
}
