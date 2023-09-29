package com.serviceimpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public ResponseEntity<String> addBook(Map<String, String> map) {
		
		try {
			
			Book book = configBook(map);
			
			if (Objects.isNull(book)) {
				return new ResponseEntity<String>("Values Mismatch",HttpStatus.BAD_REQUEST);
			} else {
				bookDao.save(book);
				return new ResponseEntity<String>("Added",HttpStatus.CREATED);
			}
			
			
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<String>("WRONG ISBN",HttpStatus.IM_USED);
		} catch (NumberFormatException e) {
			return new ResponseEntity<String>("ENTER VALID NUMBERS",HttpStatus.NOT_ACCEPTABLE);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Book configBook(Map<String, String>map) {
		
		String title = map.get("title");
		String author = map.get("author");
		String language = map.get("lang");
		Long isbn = Long.parseLong(map.get("isbn"));
		
		Book book = new Book();
		
		book.setAuthor(author);
		book.setIsbn(isbn);
		book.setLanguage(language);
		book.setTitle(title);
		
		
		return book;
		
	}
	
}
