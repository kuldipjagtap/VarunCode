package com.yourstories.controllers;

import java.util.HashMap;
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
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Author;
import com.yourstories.services.IAuthorService;
import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.*;

@RestController
public class AuthorController {

	@Autowired IAuthorService authorService;
	
	@RequestMapping(value={"/api/v1/author"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllAuthors() throws NoAuthorsFoundException{
		List<Author> fetchedAuthors = authorService.getAllAuthors();
		//throw an exception if the database does not contain any author yet...
		if(fetchedAuthors == null || fetchedAuthors.isEmpty()){
			throw new NoAuthorsFoundException("No Author found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Author>>(fetchedAuthors, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/author/{id}"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAuthor(@PathVariable("id") String id) throws NoAuthorsFoundException, PathVariableEmptyException{
		if(isEmpty(id)){
			throw new PathVariableEmptyException("PathVariable in request can't be empty.");
		}
		Author fetchedAuthor = authorService.getAuthor(id);
		//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(fetchedAuthor, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/author"}, method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author, Errors errors) throws NoAuthorsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Author fetchedAuthor = authorService.createAuthor(author);
		//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(fetchedAuthor, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/author"}, method={RequestMethod.PUT}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateAuthor(@Valid @RequestBody Author author, Errors errors) throws NoAuthorsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Author fetchedAuthor = authorService.updateAuthor(author);
		//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(fetchedAuthor, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/author"}, method={RequestMethod.DELETE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteAuthor(@Valid @RequestBody Author author, Errors errors) throws NoAuthorsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		authorService.deleteAuthor(author);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/author/{id}"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id) throws NoAuthorsFoundException{
		if(isEmpty(id)){
			throw new NoAuthorsFoundException("Id must not be null or empty.");
		}
		
		authorService.deleteAuthor(id);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Author>(headers, HttpStatus.OK);
	}
	
}
