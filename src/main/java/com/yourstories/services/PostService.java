package com.yourstories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yourstories.model.Post;
import com.yourstories.repositories.IPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

	@Autowired IPostRepository postRepository;
	
	@Override
	public List<Post> getAllPost() {
		
		return postRepository.getAllPost();
	}

	@Override
	public Post getPost(String id) {
		
		return postRepository.getPost(id);
	}

	@Override
	public Post createPost(Post post) {
		
		return postRepository.createPost(post);
	}

	@Override
	public Post updatePost(Post post) {
		
		return postRepository.updatePost(post);
	}

	@Override
	public void deletePost(Post post) {
		
		postRepository.deletePost(post);
	}

	@Override
	public void deletePost(String id) {

		postRepository.deletePost(id);
	}

	
}
