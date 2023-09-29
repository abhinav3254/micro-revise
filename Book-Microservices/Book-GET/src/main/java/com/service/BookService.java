package com.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pojo.Book;

public interface BookService {
	
	public ResponseEntity<List<Book>> getBooks();
	
}
