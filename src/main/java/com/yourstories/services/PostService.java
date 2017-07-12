package com.yourstories.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.yourstories.model.Post;
import com.yourstories.repositories.IPostRepository;

@Service
public class PostService implements IPostService{

	@Autowired IPostRepository postRepository;
	@Autowired GridFsTemplate gridfsTemplate;
	
	@Override
	public List<Post> getAllPost() {
		
		return postRepository.getAllPost();
	}

	@Override
	public Post getPost(String id) {
		
		return postRepository.getPost(id);
	}

	@Override
	public Post createPost(MultipartFile file, Post post) throws IOException {
		
		Post createdPost = postRepository.createPost(post);
		
		DBObject metaData = new BasicDBObject();
		metaData.put("postId", createdPost.getId());
		
		gridfsTemplate.store(file.getInputStream(),file.getOriginalFilename(),file.getContentType(), metaData);
		
		return createdPost;
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
