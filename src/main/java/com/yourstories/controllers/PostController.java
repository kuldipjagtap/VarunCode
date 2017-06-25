package com.yourstories.controllers;

import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.getErrors;
import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.isEmpty;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yourstories.exceptions.NoAuthorsFoundException;
import com.yourstories.exceptions.NoPostsFoundException;
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Author;
import com.yourstories.model.Post;
import com.yourstories.services.IPostService;

@RestController
public class PostController {

@Autowired IPostService postService;
	
	@RequestMapping(value={"/api/v1/post"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllPost() throws NoPostsFoundException{
		List<Post> fetchedPosts = postService.getAllPost();
		//throw an exception if the database does not contain any post yet...
		if(fetchedPosts == null || fetchedPosts.isEmpty()){
			throw new NoPostsFoundException("No Posts found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Post>>(fetchedPosts, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/post/{id}"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getPost(@PathVariable("id") String id) throws NoPostsFoundException, PathVariableEmptyException{
		if(isEmpty(id)){
			throw new PathVariableEmptyException("PathVariable in request can't be empty.");
		}
		Post fetchedPost = postService.getPost(id);
		//throw an exception if the database does not contain any author yet...
		if(fetchedPost == null){
			throw new NoPostsFoundException("No Posts found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Post>(fetchedPost, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/post"}, method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createPost(@Valid @RequestBody Post post, Errors errors) throws NoPostsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Post fetchedPost = postService.createPost(post);
		//throw an exception if the database does not contain any author yet...
		if(fetchedPost == null){
			throw new NoPostsFoundException("No Posts found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Post>(fetchedPost, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/post"}, method={RequestMethod.PUT}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updatePost(@Valid @RequestBody Post post, Errors errors) throws NoPostsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Post fetchedPost = postService.updatePost(post);
		//throw an exception if the database does not contain any author yet...
		if(fetchedPost == null){
			throw new NoPostsFoundException("No Posts found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Post>(fetchedPost, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/post"}, method={RequestMethod.DELETE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deletePost(@Valid @RequestBody Post post, Errors errors) throws NoPostsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		postService.deletePost(post);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/post/{id}"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id) throws NoPostsFoundException{
		if(isEmpty(id)){
			throw new NoPostsFoundException("Id must not be null or empty.");
		}
		
		postService.deletePost(id);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(headers, HttpStatus.OK);
	}
}
