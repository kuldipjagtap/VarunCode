package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Account;

public interface AccountRepositoryDB extends MongoRepository<Account, String>{

	Account findByUsername(String username);
	void deleteByUsername(String username);
}
