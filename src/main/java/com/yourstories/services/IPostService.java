package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.Post;

public interface IPostService {

	List<Post> getAllPost();
	Post getPost(String id);
	Post createPost(Post author);
	Post updatePost(Post author);
	void deletePost(Post author);
	void deletePost(String id);
}
