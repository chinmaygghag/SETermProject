package com.example.demo.util;


import com.example.demo.models.Comment;

import java.util.List;

public class PostAndComment {

    private long userId;

    private int postId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    private String imageUrl;

    private String audioUrl;

    private String textCaption;

    private List<Comment> comments;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
