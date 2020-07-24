package com.raja.controller;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raja.dao.BookRepristory;
import com.raja.model.Book;

@RestController
@RequestMapping("/v1/api")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookRepristory bookRepristory;
	@GetMapping("/getAllBookDetails")
	public ResponseEntity<Object> getAllBookDetails(HttpServletRequest request){
		
		Iterable<Book> bookdata = bookRepristory.findAll();
		return ResponseEntity.ok().body(bookdata);
	}
	@GetMapping("/getBookById/{bookId}")
	public ResponseEntity<Object> getBookById(HttpServletRequest request,@PathVariable("bookId") int bookId){
		
		Optional<Book> bookdataId = bookRepristory.findById(bookId);
		
		return ResponseEntity.ok().body(bookdataId);
	}

}
