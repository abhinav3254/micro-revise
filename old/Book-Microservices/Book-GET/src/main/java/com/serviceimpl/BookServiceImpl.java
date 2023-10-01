package com.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.pojo.Book;
import com.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public ResponseEntity<List<Book>> getBooks() {
		try {
			
			List<Book> listBooks = bookDao.findAll();
			
			return new ResponseEntity<List<Book>>(listBooks,HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
