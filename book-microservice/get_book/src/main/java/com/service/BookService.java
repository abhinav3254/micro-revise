package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feign.BookInterface;
import com.pojo.Book;

@Service
public class BookService {
	
	@Autowired
	private BookInterface bookInterface;


	public List<Book> findAllBooks() {
		try {
			List<Book> list = bookInterface.getAllBooks().getBody();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
