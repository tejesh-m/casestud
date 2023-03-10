package com.digitalbooks.service;

import java.util.List;
import java.util.Optional;

import com.digitalbooks.entity.Book;

public interface IBookService {
	
	Integer createBook(Book book);
	
	Book updateBook(Book book, Integer bookid);
	
	public List<Book> getallbooks();
	
	public List<Book> getbook(String title, String author, String publisher, Integer publisheddate);

	Optional<Book> getbook(Integer bookid);
	
	public void deletebook(Integer bookid);
	
	Book blockbook(Book book, Integer bookid);
}
