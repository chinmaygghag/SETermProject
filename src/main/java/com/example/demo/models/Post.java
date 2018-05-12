package com.example.demo.models;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.*;

@Entity
public class Post implements Comparator{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private long userId;

	private String imageUrl;

	private String audioUrl;

	private String textCaption;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public String getTextCaption() {
		return textCaption;
	}

	public void setTextCaption(String textCaption) {
		this.textCaption = textCaption;
	}

	private long timestamp;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public long getTimestamp() {

		return timestamp;
	}

	public void setTimestamp(long timestamp) {

		this.timestamp = timestamp;
	}


	@Override
	public int compare(Object o1, Object o2) {
		Post p1 = (Post) o1;
		Post p2 = (Post) o2;

		if (p1.getTimestamp() > p2.getTimestamp()){
			return -1;
		}else if(p1.getTimestamp() < p2.getTimestamp()){
			return 1;
		}else{
			return 0;
		}
	}
}
