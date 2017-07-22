package com.yourstories.controllers;

import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.getErrors;
import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.isEmpty;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.yourstories.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yourstories.exceptions.NoPostsFoundException;
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Author;
import com.yourstories.model.Post;
import com.yourstories.services.IPostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="YourStories", description="Operations pertaining to Post in YourStories application")
public class PostController {

@Autowired IPostService postService;
	
	@ApiOperation(value = "View a list of available post ", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully retrieved list"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
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
	
	@ApiOperation(value = "fetch post by id", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully retrieved post by id"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
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
	
	@ApiOperation(value = "create post", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully created post"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/post"}, method={RequestMethod.POST}, consumes={"multipart/forma-data"},produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createPost(@AuthenticationPrincipal User user, @Valid @RequestPart("file") MultipartFile file, @RequestPart("post") Post post, Errors errors) throws NoPostsFoundException,IOException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		post.setUser(user);
		Post fetchedPost = postService.createPost(file,post);
		//throw an exception if the database does not contain any author yet...
		if(fetchedPost == null){
			throw new NoPostsFoundException("No Posts found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Post>(fetchedPost, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "update post", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully updated post"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
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
	
	@ApiOperation(value = "delete post", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully deleted post"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
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
	
	@ApiOperation(value = "delete post by id", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully deleted post by id"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
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
