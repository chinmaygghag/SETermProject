package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public ArrayList<Users> getAllUsers(){
		ArrayList<Users> users = (ArrayList<Users>) repository.findAll();
		return users;
	}
	
	public Users findUserByName(String username) {
		Users user = repository.findByUsername(username);
		return user;
	}
	
	public boolean findUserExists(String username) {
		Users user = repository.findByUsername(username);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void saveUser(Users user) {
		repository.save(user);
	}
}
