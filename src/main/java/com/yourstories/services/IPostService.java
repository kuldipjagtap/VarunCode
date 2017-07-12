package com.yourstories.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yourstories.model.Post;

public interface IPostService {

	List<Post> getAllPost();
	Post getPost(String id);
	Post createPost(MultipartFile file,Post post) throws IOException;
	Post updatePost(Post author);
	void deletePost(Post author);
	void deletePost(String id);
}
