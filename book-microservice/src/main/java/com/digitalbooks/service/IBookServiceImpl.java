package com.digitalbooks.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Book;
import com.digitalbooks.exception.ResourceNotFoundException;

@Service
public class IBookServiceImpl implements IBookService {
	
	@Autowired
	IBookRepo iBookRepo;

	@Override
	public Integer createBook(Book book) {
		
		Book savebook = iBookRepo.save(book);
		
		return savebook.getBookid();
	}

	@Override
	public Book updateBook(Book book, Integer bookid) {
		Book updatebook = iBookRepo.findById(bookid).orElseThrow(
				()-> new ResourceNotFoundException("Book", "bookid", bookid));
		updatebook.setTitle(book.getTitle());
		updatebook.setCategory(book.getCategory());
		updatebook.setPrice(book.getPrice());
		updatebook.setAuthor(book.getAuthor());
		updatebook.setPublisher(book.getPublisher());
		updatebook.setPublisheddate(book.getPublisheddate());
		updatebook.setChapters(book.getChapters());
		updatebook.setActive(book.getActive());
		iBookRepo.save(updatebook);
		return updatebook;
	}

	@Override
	public List<Book> getallbooks() {
		
		return iBookRepo.findAll() ;
	}

	@Override
	public List<Book> getbook(String title, String author, String publisher, Integer publisheddate) {
		List<Book> allbooks = iBookRepo.findAll();
		if(title !=null && author !=null && publisher !=null && publisheddate!=0) {
			allbooks=allbooks.stream()
					.filter(bo -> bo.getTitle().equals(title))
					.filter(bo ->bo.getAuthor().equals(author))
					.filter(bo ->bo.getPublisher().equals(publisher))
					.filter(bo ->bo.getPublisheddate() <= publisheddate)
					.collect(Collectors.toList());
		}
		return allbooks;
	}

	@Override
	public Optional<Book> getbook(Integer bookid) {
		
		return iBookRepo.findById(bookid);
	}

	@Override
	public void deletebook(Integer bookid) {
		iBookRepo.deleteById(bookid);
		
	}

	@Override
	public Book blockbook(Book book, Integer bookid) {
		
		Book Deletebook = iBookRepo.findById(bookid).orElseThrow(
				()-> new ResourceNotFoundException("Book", "bookid", bookid));
		Deletebook.setTitle(book.getTitle());
		Deletebook.setCategory(book.getCategory());
		Deletebook.setPrice(book.getPrice());
		Deletebook.setAuthor(book.getAuthor());
		Deletebook.setPublisher(book.getPublisher());
		Deletebook.setPublisheddate(book.getPublisheddate());
		Deletebook.setChapters(book.getChapters());
		Deletebook.setActive(book.getActive());
		iBookRepo.save(Deletebook);
		return Deletebook;
	}

	

	

	

	

	

	

	
	

}
