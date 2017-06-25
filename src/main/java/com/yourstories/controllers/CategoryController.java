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

import com.yourstories.exceptions.NoAccountsFoundException;
import com.yourstories.exceptions.NoAuthorsFoundException;
import com.yourstories.exceptions.NoCategoriesFoundException;
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Account;
import com.yourstories.model.Category;
import com.yourstories.services.ICategoryService;

@RestController
public class CategoryController {

@Autowired ICategoryService categoryService;
	
	@RequestMapping(value={"/api/v1/category"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllCategories() throws NoCategoriesFoundException{
		List<Category> fetchedCategories = categoryService.getAllCategory();
		//throw an exception if the database does not contain any author yet...
		if(fetchedCategories == null || fetchedCategories.isEmpty()){
			throw new NoCategoriesFoundException("No categories found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Category>>(fetchedCategories, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/category/{username}"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getCategory(@PathVariable("id") String id) throws NoCategoriesFoundException, PathVariableEmptyException{
		if(isEmpty(id)){
			throw new PathVariableEmptyException("PathVariable in request can't be empty.");
		}
		Category fetchedCategory = categoryService.getCategory(id);
		//throw an exception if the database does not contain any author yet...
		if(fetchedCategory == null){
			throw new NoCategoriesFoundException("No Category found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Category>(fetchedCategory, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/category"}, method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createAccount(@Valid @RequestBody Category category, Errors errors) throws NoCategoriesFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Category fetchedCategory = categoryService.createCategory(category);
		//throw an exception if the database does not contain any author yet...
		if(fetchedCategory == null){
			throw new NoCategoriesFoundException("No Category found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Category>(fetchedCategory, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/category"}, method={RequestMethod.PUT}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateAccount(@Valid @RequestBody Category category, Errors errors) throws NoCategoriesFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Category fetchedCategory = categoryService.updateCategory(category);
		//throw an exception if the database does not contain any author yet...
		if(fetchedCategory == null){
			throw new NoCategoriesFoundException("No Account found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Category>(fetchedCategory, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/category"}, method={RequestMethod.DELETE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteAccount(@Valid @RequestBody Category category, Errors errors) throws NoCategoriesFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		categoryService.deleteCategory(category);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Category>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/v1/category/{id}"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> deleteCategory(@PathVariable("id") String id) throws NoCategoriesFoundException{
		if(isEmpty(id)){
			throw new NoCategoriesFoundException("Id must not be null or empty.");
		}
		
		categoryService.deleteCategory(id);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Category>(headers, HttpStatus.OK);
	}
}
