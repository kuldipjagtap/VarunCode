package com.yourstories.controllers;

import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.getErrors;
import static com.yourstory.exceptions.util.ErrorAndExceptionUtil.isEmpty;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yourstories.exceptions.NoAccountsFoundException;
import com.yourstories.exceptions.NoAuthorsFoundException;
import com.yourstories.exceptions.PathVariableEmptyException;
import com.yourstories.model.Account;
import com.yourstories.services.IAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="YourStories", description="Operations pertaining to User Account in YourStories application")
public class AccountController {

@Autowired
IAccountService accountService;
	
	@ApiOperation(value = "View a list of available accounts", response = ResponseEntity.class)
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(value={"/api/v1/account"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllAccounts() throws NoAccountsFoundException{
		List<Account> fetchedAccounts = accountService.getAllAccounts();
		//throw an exception if the database does not contain any author yet...
		if(fetchedAccounts == null || fetchedAccounts.isEmpty()){
			throw new NoAccountsFoundException("No account found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Account>>(fetchedAccounts, headers, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "fetch account details by username", response = ResponseEntity.class)
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved account details by username"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(value={"/api/v1/account/{username}"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAccount(@PathVariable("username") String username) throws NoAccountsFoundException, PathVariableEmptyException{
		if(isEmpty(username)){
			throw new PathVariableEmptyException("PathVariable in request can't be empty.");
		}
		Account fetchedAccount = accountService.getAccount(username);
		//throw an exception if the database does not contain any author yet...
		if(fetchedAccount == null){
			throw new NoAccountsFoundException("No Account found in database.");
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Account>(fetchedAccount, headers, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "create account", response = ResponseEntity.class)
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully created account"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(value={"/api/v1/account"}, method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createAccount(@Valid @RequestBody Account account, Errors errors) throws NoAccountsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Account fetchedAccount = accountService.createAccount(account);
		//throw an exception if the database does not contain any author yet...
		if(fetchedAccount == null){
			throw new NoAccountsFoundException("No Account found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Account>(fetchedAccount, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "update account", response = ResponseEntity.class)
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully updated account"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(value={"/api/v1/account"}, method={RequestMethod.PUT}, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateAccount(@Valid @RequestBody Account account, Errors errors) throws NoAccountsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		Account fetchedAccount = accountService.updateAccount(account);
		//throw an exception if the database does not contain any author yet...
		if(fetchedAccount == null){
			throw new NoAccountsFoundException("No Account found in database.");
		}
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Account>(fetchedAccount, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "delete account", response = ResponseEntity.class)
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully deleted account"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(value={"/api/v1/account"}, method={RequestMethod.DELETE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteAccount(@Valid @RequestBody Account account, Errors errors) throws NoAccountsFoundException{
		Map<String, String> fieldErrors = getErrors(errors);
		if(fieldErrors != null){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Map<String, String>>(fieldErrors, headers, HttpStatus.BAD_REQUEST);
		}
		accountService.deleteAccount(account);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Account>(headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "delete account by username", response = ResponseEntity.class)
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully deleted account by username"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(value={"/api/v1/account/{username}"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> deleteAccount(@PathVariable("username") String username) throws NoAuthorsFoundException{
		if(isEmpty(username)){
			throw new NoAuthorsFoundException("Id must not be null or empty.");
		}
		
		accountService.deleteAccount(username);
		/*//throw an exception if the database does not contain any author yet...
		if(fetchedAuthor == null){
			throw new NoAuthorsFoundException("No Author found in database.");
		}*/
		//return the entity to the client...
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Account>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Expose user details to UI for authorities and roles", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully exposed user"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value={"/api/v1/user/"}, method={RequestMethod.DELETE})
	public ResponseEntity<?> getUser(Principal principal) throws UsernameNotFoundException{
		if(principal == null){
			throw new UsernameNotFoundException("User does not exist.");
		}

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Principal>(principal, HttpStatus.OK);
	}


}

