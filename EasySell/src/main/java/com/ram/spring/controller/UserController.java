package com.ram.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ram.spring.model.User;
import com.ram.spring.exception.RsourceNotFoundException;

import com.ram.spring.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private  UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
    @PostMapping("/users")
	public User createUsers(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value="id") Integer id) {
		return userRepository.findById(id).orElseThrow(() ->new RsourceNotFoundException("User","id",id));
	}
}
