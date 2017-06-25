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
import com.yourstories.exceptions.NoTagsFoundException;
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Author;
import com.yourstories.model.Tag;
import com.yourstories.services.ITagService;

@RestController
public class TagController {

@Autowired ITagService tagService;
	
	@RequestMapping(value={"/api/v1/tag"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllTag() throws NoTagsFoundException{
		List<Tag> fetchedTags = tagService.getAllTags();
		//throw an exception if the database does not contain any author yet...
		if(fetchedTags == null || fetchedTags.isEmpty()){
			throw new NoTagsFoundException("No Tag found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Tag>>(fetchedTags, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/tag/{id}"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getTag(@PathVariable("id") String id) throws NoTagsFoundException, PathVariableEmptyException{
		if(isEmpty(id)){
			throw new PathVariableEmptyException("PathVariable in request can't be empty.");
		}
		Tag fetchedTag = tagService.getTag(id);
		//throw an exception if the database does not contain any author yet...
		if(fetchedTag == null){
			throw new NoTagsFoundException("No Tag found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Tag>(fetchedTag, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/tag"}, method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createTag(@Valid @RequestBody Tag tag, Errors errors) throws NoTagsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Tag fetchedTag = tagService.createTag(tag);
		//throw an exception if the database does not contain any author yet...
		if(fetchedTag == null){
			throw new NoTagsFoundException("No Tag found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Tag>(fetchedTag, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/tag"}, method={RequestMethod.PUT}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateTag(@Valid @RequestBody Tag tag, Errors errors) throws NoTagsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Tag fetchedTag = tagService.updateTag(tag);
		//throw an exception if the database does not contain any author yet...
		if(fetchedTag == null){
			throw new NoTagsFoundException("No Tag found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Tag>(fetchedTag, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/tag"}, method={RequestMethod.DELETE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteTag(@Valid @RequestBody Tag tag, Errors errors) throws NoTagsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		tagService.deleteTag(tag);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Tag>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/tag/{id}"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> deleteTag(@PathVariable("id") String id) throws NoTagsFoundException{
		if(isEmpty(id)){
			throw new NoTagsFoundException("Id must not be null or empty.");
		}
		
		tagService.deleteTag(id);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Tag>(headers, HttpStatus.OK);
	}
}
