package com.yourstories.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.yourstories.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepsitory implements IPostRepository{

	@Autowired MongoTemplate mongoTemplate;
	@Autowired PostRepositoryDB postRepositoryDB;
	
	@Override
	public List<Post> getAllPost() {
		
		return postRepositoryDB.findAll();
	}

	@Override
	public Post getPost(String id) {
		
		return postRepositoryDB.findOne(id);
	}

	@Override
	public Post createPost(Post post) {
		
		return postRepositoryDB.save(post);
	}

	@Override
	public Post updatePost(Post post) {
		
		return postRepositoryDB.save(post);
	}

	@Override
	public void deletePost(Post post) {
		postRepositoryDB.delete(post);
		
	}

	@Override
	public void deletePost(String id) {
		postRepositoryDB.delete(id);
		
	}

	
}
