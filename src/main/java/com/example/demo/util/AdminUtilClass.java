package com.example.demo.util;

import com.example.demo.models.Post;

import java.util.List;

public class AdminUtilClass {

    private List<String> username;

    private List<Post> postList;

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
