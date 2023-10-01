package com.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.pojo.Book;


@FeignClient("ADD-BOOK")
public interface BookInterface {

	@GetMapping("/add/all")
	public ResponseEntity<List<Book>> getAllBooks();
	
}
