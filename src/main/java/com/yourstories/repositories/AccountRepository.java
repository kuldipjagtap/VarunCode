package com.yourstories.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.yourstories.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository implements IAccountRepository{

	@Autowired MongoTemplate mongoTemplate;
	@Autowired AccountRepositoryDB accountRepositoryDB;
	
	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepositoryDB.findAll();
	}

	@Override
	public Account getAccount(String username) {
		
		return accountRepositoryDB.findByUsername(username);
	}

	@Override
	public Account createAccount(Account account) {
		
		return accountRepositoryDB.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		
		return accountRepositoryDB.save(account);
	}

	@Override
	public void deleteAccount(Account account) {
		accountRepositoryDB.delete(account);
		
	}

	@Override
	public void deleteAccount(String username) {
		accountRepositoryDB.deleteByUsername(username);
		
	}

	
}
