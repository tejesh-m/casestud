package com.digitalbooks.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserServiceDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if ("naveen".equals(username)) {
			return new User(
					"naveen", 
			"{noop}demo@123", 
					
					new ArrayList<>()
				);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}
}
