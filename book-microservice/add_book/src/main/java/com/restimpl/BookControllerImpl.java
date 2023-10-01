package com.restimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Book;
import com.rest.BookController;
import com.service.BookService;

@RestController
public class BookControllerImpl implements BookController {
	
	@Autowired
	private BookService bookService;

	@Override
	public ResponseEntity<String> addBook(Book book) {
		String res = null;
		try {
			res = bookService.addBook(book);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}

	@Override
	public ResponseEntity<List<Book>> getAllBooks() {
		try {
			List<Book> books = bookService.findAllBooks();
			
			if (books.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(books);
			return ResponseEntity.status(HttpStatus.OK).body(books);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
