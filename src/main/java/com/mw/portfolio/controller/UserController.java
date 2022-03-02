package com.mw.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.portfolio.model.User;
import com.mw.portfolio.service.UserService;

@Controller
@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String viewLandingPage() {
		return "index";
	}
	
	@PostMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		userservice.addUser(user);
		return "register_success";
	}
	
	@GetMapping("/login/{id}")
	public String edit(@PathVariable Long id, Model m, String tempUserName, String tempPassWord) {
		
		User user=userservice.getEmpById(id);
		//m.addAttribute("user",user);
		String password = user.getPassword();
		String email = user.getEmail();
		if(tempUserName.equals(email) && tempPassWord.equals(password))
			return "portfolio";
		else
			return "login_error";
	}
	
	@GetMapping("/users")
	public List<User> listUsers(Model model) {
		List<User> users = userservice.getAllUser();
		return users;
	}

}
