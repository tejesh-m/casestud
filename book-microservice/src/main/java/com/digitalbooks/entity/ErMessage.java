package com.digitalbooks.entity;

import java.time.LocalDate;

public class ErMessage {

	private String message;
	private String type;
	private String desc;
	private LocalDate date;
	public ErMessage() {
		super();
	}
	public ErMessage(String message, String type, String desc, LocalDate date) {
		super();
		this.message = message;
		this.type = type;
		this.desc = desc;
		this.date = date;
	}
	public ErMessage(String message, String type, String desc) {
		super();
		this.message = message;
		this.type = type;
		this.desc = desc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
