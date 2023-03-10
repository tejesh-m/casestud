package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entity.Author;
import com.digitalbooks.exception.AuthorException;
import com.digitalbooks.service.AuthorService;

@RestController
@RequestMapping("api/v1/digitalbooks")
public class CredentialsController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/signup")
	 public String createAuthor(@RequestBody Author author) throws AuthorException
    {
        System.out.println("username " +author.getUsername());
        System.out.println("username " +author.getPassword());
        System.out.println("username " +author.getEmailId());
    return authorService.saveCredentials(author);    
    }
	
	
	 @PostMapping("/login")
	    public String authorLogin(@RequestBody Author author) throws AuthorException
	    {
	        String username=author.getUsername();
	        System.out.println("username" +username);
	        String password=author.getPassword();
	        String s=authorService.validateUser(username,password);
	        if(s.equalsIgnoreCase("success"))
	        {
	            return "You have been Successfully logged in";    
	        }
	        else if(s.equalsIgnoreCase("failure"))
	        {
	            return "Password is incorrect,Please enter correct password";
	        }
	        else
	        {
	            return "User does not exist,Please register";
	        }
	        
	    }

}
