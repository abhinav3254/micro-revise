package com.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * RESTful API for managing books.
 */
@RequestMapping("/add")
public interface BookRest {
	
	
	/**
     * Adds a new book to the system.
     *
     * @param map A map containing key-value pairs representing book attributes.
     *            Required keys: "title", "author", "publicationYear", etc.
     * @return A ResponseEntity with a message indicating the result of the operation.
     *         - HttpStatus.CREATED (201) if the book is successfully added.
     *         - HttpStatus.BAD_REQUEST (400) if the request body is invalid or missing required fields.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an unexpected error occurs.
     */
	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@RequestBody(required = true)Map<String, String>map);

}
