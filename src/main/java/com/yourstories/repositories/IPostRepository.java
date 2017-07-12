package com.yourstories.repositories;

import java.util.List;

import com.yourstories.model.Post;

public interface IPostRepository {

	List<Post> getAllPost();
	Post getPost(String id);
	Post createPost(Post post);
	Post updatePost(Post author);
	void deletePost(Post author);
	void deletePost(String id);
}
