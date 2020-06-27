package com.fahrul.springjunitmockito.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fahrul.springjunitmockito.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
	List<User> findByAddress(String address);

}
