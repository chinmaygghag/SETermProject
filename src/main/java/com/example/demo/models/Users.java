package com.example.demo.models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
public class Users{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;
	
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ElementCollection
    @CollectionTable(name="allPost")
	@OneToMany(targetEntity = Post.class,
	fetch = FetchType.EAGER,
	cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Post> allPost;
	
	private String friends;
	
	@OneToOne(targetEntity=Profile.class, 
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL)
	private Profile profile;
	
	
	@ElementCollection
    @CollectionTable(name="allNotifications")
	@OneToMany(targetEntity = Notifications.class,
	fetch = FetchType.EAGER,
	cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Notifications> currentNotifications;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Notifications> getCurrentNotifications() {
		return currentNotifications;
	}

	public void setCurrentNotifications(ArrayList<Notifications> currentNotifications) {
		this.currentNotifications = currentNotifications;
	}

	public List<Post> getAllPost() {
		return allPost;
	}

	public void setAllPost(ArrayList<Post> allPost) {
		this.allPost = allPost;
	}

	

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
}
