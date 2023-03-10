package com.digitalbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.digitalbooks.entity.Book;
import com.digitalbooks.service.IBookService;


@RestController
@RequestMapping("/api/v1/digitalbooks")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthorController {
	
	@Autowired
	IBookService iBookService;
	
	
	
	@PostMapping("/author/books")
     Integer createbook(@RequestBody Book book) {
		
		Integer id  = iBookService.createBook(book);
		System.out.println(id);
		return id;
	}
	
	@PutMapping("/author/{bookid}")
	public ResponseEntity<Book>updatebook(@PathVariable("bookid") Integer bookid, @RequestBody Book book){
		return new ResponseEntity<Book>(iBookService.updateBook(book, bookid), HttpStatus.OK);
	}
	
	@GetMapping("/author/allbooks")
	public List getallbooks() {
		return iBookService.getallbooks();
	}
	
	@GetMapping("/search")
	public List<Book> getbooks(@RequestParam String title, @RequestParam String author,
			@RequestParam String publisher, @RequestParam Integer publisheddate){
		
		return iBookService.getbook(title, author, publisher, publisheddate);
	}
	
	@GetMapping("/read/{bookid}")
	public Optional<Book> getbook(@PathVariable Integer bookid){
		Optional<Book> book = iBookService.getbook(bookid);
		return book;
	}
	
	@DeleteMapping("/remove/{bookid}")
	public ResponseEntity<Book> deletebook(@PathVariable Integer bookid){
		System.out.println(bookid);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			iBookService.deletebook(bookid);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@PutMapping("/author/{bookid}/block")
	public ResponseEntity<Book>Blockbook(@PathVariable("bookid") Integer bookid, @RequestBody Book book){
		return new ResponseEntity<Book>(iBookService.blockbook(book, bookid), HttpStatus.OK);
	}
	
	
}
