package com.tera.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tera.Model.User;
import com.tera.Repository.UserRepository;

@RestController
@RequestMapping("/user/admin")
public class UserAdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/add")
	public String addAdmin(@RequestBody User user) {
		
		String pwd = user.getPassword();
		String encryptedPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptedPwd);
		userRepository.save(user);
		return "User Added Successfully...";
	}
}
