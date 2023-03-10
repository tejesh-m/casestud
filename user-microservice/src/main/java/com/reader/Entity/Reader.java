package com.reader.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer readerId;
	private String name;
	private String remailid;
	private String rpassword;
	
	public Integer getReaderId() {
		return readerId;
	}
	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemailid() {
		return remailid;
	}
	public void setRemailid(String remailid) {
		this.remailid = remailid;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	
	public Reader(Integer readerId, String name, String remailid, String rpassword) {
		super();
		this.readerId = readerId;
		this.name = name;
		this.remailid = remailid;
		this.rpassword = rpassword;
	}
	public Reader() {
		super();
	}
	

}
