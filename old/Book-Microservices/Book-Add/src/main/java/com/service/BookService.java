package com.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface BookService {
	
	public ResponseEntity<String> addBook(Map<String, String>map);
	
}
