package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.models.Users;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    PostRepository repository;

    @Autowired
    UserRepository userRepository;

    public void deletePost(Post p){
        repository.delete(p);
    }


    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public List<Post> getAllPosts(){
        return (List<Post>) repository.findAll();
    }


}
