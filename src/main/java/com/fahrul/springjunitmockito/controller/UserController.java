package com.fahrul.springjunitmockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fahrul.springjunitmockito.model.User;
import com.fahrul.springjunitmockito.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> findAllUser(){
		return service.getUsers();
	}
	
	@GetMapping("/getUserByAddress/{}address")
	public List<User> findUserByAddress(@PathVariable String address){
		return service.getUserByAddress(address);
	}
	
	@DeleteMapping(value = "/remove")
	public User deleteUser(@RequestBody User user) {
		service.deleteUser(user);
		return user;
	}
}
