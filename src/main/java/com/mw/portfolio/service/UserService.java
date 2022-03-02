package com.mw.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//mport com.mw.portfolio.controller.BCryptPasswordEncoder;
import com.mw.portfolio.model.User;
import com.mw.portfolio.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public void addUser(User user) {
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String encodedPassword = passwordEncoder.encode(user.getPassword());
		//user.setPassword(encodedPassword);
		
		userRepo.save(user);
	}
	
	public List<User> getAllUser(){
		List<User> users = null;
		users = (List<User>) userRepo.findAll();
		return users;
	}

	public User getEmpById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
		
}
