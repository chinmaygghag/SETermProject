package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
