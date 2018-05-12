package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Users{
	
	@Id
	@Column(name = "users_id")
	private long id;

	private String username;
	
	private String email;
	
	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public long getId() {

		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
