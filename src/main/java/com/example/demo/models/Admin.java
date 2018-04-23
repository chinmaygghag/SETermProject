package com.example.demo.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private String password;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private ArrayList<Users> allUsers;
	
	private ArrayList<Post> allPost;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Users> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(ArrayList<Users> allUsers) {
		this.allUsers = allUsers;
	}

	public ArrayList<Post> getAllPost() {
		return allPost;
	}

	public void setAllPost(ArrayList<Post> allPost) {
		this.allPost = allPost;
	}
	
	
	
}
