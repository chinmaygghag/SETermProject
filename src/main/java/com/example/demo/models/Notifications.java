package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notifications {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private long userId;

	private int postId;

	private String message;

	private boolean isVisited;

	private long toBeNotified;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean visited) {
		isVisited = visited;
	}

	public long getToBeNotified() {
		return toBeNotified;
	}

	public void setToBeNotified(long toBeNotified) {
		this.toBeNotified = toBeNotified;
	}
}
