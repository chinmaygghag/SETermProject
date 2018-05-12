package com.example.demo.repository;

import com.example.demo.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository  extends CrudRepository<Comment, Integer> {

    List<Comment> findByPostId(int postId);



}
