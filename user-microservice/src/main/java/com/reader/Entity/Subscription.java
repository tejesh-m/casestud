package com.reader.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subscriptionId;

	private Integer readerId;
	private LocalDateTime date;

	private Integer bookid;

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	

	public Integer getReaderId() {
		return readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	

	public Subscription(Integer subscriptionId, Integer readerId, LocalDateTime date, Integer bookid) {
		super();
		this.subscriptionId = subscriptionId;
		this.readerId = readerId;
		this.date = date;
		this.bookid = bookid;
	}

	public Subscription() {
		super();
	}

	
}
