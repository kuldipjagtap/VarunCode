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

import com.yourstories.exceptions.NoCommentsFoundException;
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Comment;
import com.yourstories.services.ICommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="YourStories", description="Operations pertaining to Comment in YourStories application")
public class CommentController {

@Autowired ICommentService commentService;
	
	@ApiOperation(value = "View a list of all comments ", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully retrieved list"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/comment"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllComments() throws NoCommentsFoundException{
		List<Comment> fetchedComments = commentService.getAllComment();
		//throw an exception if the database does not contain any author yet...
		if(fetchedComments == null || fetchedComments.isEmpty()){
			throw new NoCommentsFoundException("No comment found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Comment>>(fetchedComments, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "fetch comment by id", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully retrieved comment by id"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/comment/{id}"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getComment(@PathVariable("id") String id) throws NoCommentsFoundException, PathVariableEmptyException{
		if(isEmpty(id)){
			throw new PathVariableEmptyException("PathVariable in request can't be empty.");
		}
		Comment fetchedComment = commentService.getComment(id);
		//throw an exception if the database does not contain any author yet...
		if(fetchedComment == null){
			throw new NoCommentsFoundException("No Comment found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Comment>(fetchedComment, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "create comment", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully created comment"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/comment"}, method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createComment(@Valid @RequestBody Comment comment, Errors errors) throws NoCommentsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Comment fetchedComment = commentService.createComment(comment);
		//throw an exception if the database does not contain any author yet...
		if(fetchedComment == null){
			throw new NoCommentsFoundException("No Account found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Comment>(fetchedComment, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "update comment", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully updated comment"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/comment"}, method={RequestMethod.PUT}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateComment(@Valid @RequestBody Comment comment, Errors errors) throws NoCommentsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Comment fetchedComment = commentService.updateComment(comment);
		//throw an exception if the database does not contain any author yet...
		if(fetchedComment == null){
			throw new NoCommentsFoundException("No Comment found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Comment>(fetchedComment, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "delete comment", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully deleted comment"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/comment"}, method={RequestMethod.DELETE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteComment(@Valid @RequestBody Comment comment, Errors errors) throws NoCommentsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		commentService.deleteComment(comment);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Comment>(headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "delete comment by id", response = ResponseEntity.class)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message = "Successfully deleted comment by id"),
	           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	   })
	@RequestMapping(value={"/api/v1/comment/{id}"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> deleteAccount(@PathVariable("id") String id) throws NoCommentsFoundException{
		if(isEmpty(id)){
			throw new NoCommentsFoundException("Id must not be null or empty.");
		}
		
		commentService.deleteComment(id);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Comment>(headers, HttpStatus.OK);
	}
}
