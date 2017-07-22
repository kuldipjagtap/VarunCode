package com.yourstories.services;

import java.io.IOException;
import java.util.List;

import org.springframework.security.access.method.P;
import org.springframework.web.multipart.MultipartFile;

import com.yourstories.model.Post;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IPostService {

	@PreAuthorize("hasAuthority('VIEW_ALL_POSTS')")
	List<Post> getAllPost();
	@PreAuthorize("hasAuthority('VIEW_POST')")
	Post getPost(String id);
	@PreAuthorize("hasAuthority('CREATE_POST')")
	Post createPost(MultipartFile file,Post post) throws IOException;
	@PreAuthorize("#authentication.equals(p.user) and hasAuthority('UPDATE_OWN_POST') or hasAuthority('UPDATE_OTHERS_POST')")
	Post updatePost(@P("p") Post post);
	@PreAuthorize("#authentication.equals(p.user) and hasAuthority('DELETE_OWN_POST') or hasAuthority('DELETE_OTHERS_POST')")
	void deletePost(@P("p") Post post);
	@PreAuthorize("hasAuthority('DELETE_OWN_POST') or hasAuthority('DELETE_OTHERS_POST')")
	void deletePost(String id);
}
