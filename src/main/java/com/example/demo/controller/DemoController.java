package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserEntityRepository;

@Controller
public class DemoController {

	@Autowired
	private UserEntityRepository entityRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/login")
	private String login() {

		return "login";
	}

	@GetMapping("/dashboard")
	private String dashboard(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        model.addAttribute("username", username);

		return "dashboard";
	}
	
	@GetMapping("/registerPage")
	private String registerPage() {

		return "register";
	}

	@PostMapping("/register")
	private String addUser(UserEntity request) {

		UserEntity entity = new UserEntity();
		
		BeanUtils.copyProperties(request, entity);

		entity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

		entityRepository.save(entity);
		
		return "redirect:/login";
	}

}
