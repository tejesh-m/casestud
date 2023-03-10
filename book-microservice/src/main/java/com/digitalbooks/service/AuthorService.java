package com.digitalbooks.service;

import com.digitalbooks.entity.Author;
import com.digitalbooks.exception.AuthorException;

public interface AuthorService {
	
	public String saveCredentials(Author author) throws AuthorException;
	public String validateUser(String username,String password) throws AuthorException;

}
