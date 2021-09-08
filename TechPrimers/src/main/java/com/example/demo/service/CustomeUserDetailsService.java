package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class CustomeUserDetailsService  implements UserDetailsService{

	@Autowired
	private  UserRepository repo;
	
	@Autowired
	private Users users;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		try {
			Users user=repo.findByEmail(email);
			//user.ifPresent(user->new CustomUserDetails(user));
			//user.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
			return new CustomUserDetails(user);
		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("Username not found");
		}
	}

}
