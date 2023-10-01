package com.restimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Book;
import com.rest.BookRest;
import com.service.BookService;


@RestController
public class BookRestImpl implements BookRest {
	
	@Autowired
	private BookService bookService;

	@Override
	public ResponseEntity<List<Book>> addBook() {
		try {
			return bookService.getBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

}
