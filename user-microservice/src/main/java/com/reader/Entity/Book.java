package com.reader.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookid;
	private String title;
	private String category;
	private Integer price;
	private String author;
	private String publisher;
	private Integer publisheddate;
	private String chapters;
	private Boolean active;
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(Integer publisheddate) {
		this.publisheddate = publisheddate;
	}
	public String getChapters() {
		return chapters;
	}
	public void setChapters(String chapters) {
		this.chapters = chapters;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Book(Integer bookid, String title, String category, Integer price, String author, String publisher,
			Integer publisheddate, String chapters, Boolean active) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publisheddate = publisheddate;
		this.chapters = chapters;
		this.active = active;
	}
	public Book() {
		super();
	}
	
	
}
