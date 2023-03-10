package com.digitalbooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Author;
import com.digitalbooks.exception.AuthorException;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public String saveCredentials(Author author) throws AuthorException {
		
		try
		{
        authorRepo.save(author);
        return "Registration success , Please Login" ;
		}
		catch(Exception ae)
		{
			throw new AuthorException("Registration failed");
		}
	}

	@Override
	public String validateUser(String username, String password) throws AuthorException {
		
		String dbPassword=    authorRepo.filterByPassword(username);
	    if(dbPassword != null)
	    {
	        if(dbPassword.equals(password))
	        {
	            return "success";
	        }
	        else
	        {
	            return "failure";
	        }
	    }
	    else
	    {
	        return "false";
	    }
	    
	    }

}
