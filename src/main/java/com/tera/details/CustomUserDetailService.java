package com.tera.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tera.Model.User;
import com.tera.Repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	
	private UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (username == null) {
			
			throw new UsernameNotFoundException("User Name Not Found...");
		}
		
		
		return new CustomUserDetail(user);
	}

}
