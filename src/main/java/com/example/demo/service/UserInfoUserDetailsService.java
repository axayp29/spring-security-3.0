package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.config.UserEntityUserDetails;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserEntityRepository;

public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserEntityRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> entity = repository.findByUsername(username);

		return entity.map(UserEntityUserDetails::new)
		.orElseThrow(() -> new UsernameNotFoundException("Username not found in DB"));
		
	}

}
