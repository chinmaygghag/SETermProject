package com.example.demo.services;

import com.example.demo.models.Comment;
import com.example.demo.models.Users;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Post;
import com.example.demo.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	@Autowired
	private CommentRepository commentRepository;
	
	public void savePosts(Post post) {
		repository.save(post);
	}

	public List<Post> getPostByUserId(long userId){
		return repository.findAllByUserId(userId);
	}


	public Post getPostById(int postId){
		return repository.findById(postId);
	}

	public List<Comment> getCommentByPostId(int postId){
		return commentRepository.findByPostId(postId);
	}

	public Comment addComment(Comment comment){
		return commentRepository.save(comment);
	}

}
