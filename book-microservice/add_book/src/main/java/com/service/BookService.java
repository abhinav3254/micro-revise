package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.pojo.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	public String addBook(Book book) {
		try {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//			ZonedDateTime zonedDateTime = ZonedDateTime.parse(book.getPublishedDate().get$date().toString(), formatter);
			
			
			bookDao.save(book);
			
			return "saved";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "not saved";
	}

	public List<Book> findAllBooks() {
		try {
			List<Book> books = bookDao.findAll();
			
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
